package com.jdk.mem.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdk.mem.service.MemberService;
import com.jdk.mem.service.MemberServiceImpl;
import com.jdk.util.MailUtil;
import com.jdk.util.messageUtil;
import com.jdk.vo.MemberVO;

@Controller
public class memberMainMoveAction {
	
	@Autowired
	public MemberService service = null;
	@Autowired
	private messageUtil util = null;
	@Autowired
	private MailUtil mailUtil = null;
	
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}

	public void setUtil(messageUtil util) {
		this.util = util;
	}
	
	public void setService(MemberService service) {
		this.service = service;
	}
	
	static Logger logger = Logger.getLogger(memberMainMoveAction.class);
	//처음시작 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Model model,ModelAndView mav,HttpServletResponse response) throws IOException {
		logger.info("((((((((((((("+getClass()+"START(method : home)))))))))))))))))");
		mav.addObject("title", "jdk's home 로그인전");
		mav.setViewName("beforeLogin-layout");
		logger.info("((((((((((((("+getClass()+"END(method : home))))))))))))))))))");
		return mav;
	}
	
	//로그인
	@RequestMapping(value = "/login.jdk", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("memberVO")MemberVO form,HttpSession session, ModelAndView mav){
		logger.info("((((((((((((("+getClass()+"START(method : login)))))))))))))))))");
		
		try {
			
			if(service.memberCount(form) <= 0){
				logger.info("(((((((((((((NULLPOINTEREXCEPTION(로그인에 실패했습니다.) END(method : login))))))))))))))))))");
				mav.setViewName("alert-layout");
				mav.addObject("message", util.getMessage("all.process.fail",new String[]{"로그인을"}));
				mav.addObject("url", "/");
				return mav;
			}
			form = service.memberSelect(form);
			session.setAttribute("userInfo", form);
			
			if(form.equals("") || form.equals("null")){}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("(((((((((((((SQLException(구문오류) END(method : login))))))))))))))))))");
			
			mav.addObject("message", util.getMessage("all.process.fail",new String[]{"로그인을"}));
			mav.addObject("url", "./");
			
			mav.setViewName("alert-layout");
			//에러일떄는 메시지 보여주고 로그인화면으로 다시감
			return mav;
		} catch (NullPointerException e){
			logger.info("(((((((((((((NULLPOINTEREXCEPTION(진짜 널이거나 아이디가 없습니다.) END(method : login))))))))))))))))))");
			
			mav.addObject("message", util.getMessage("all.process.fail",new String[]{"로그인을"}));
			mav.addObject("url", "./");
			
			mav.setViewName("alert-layout");
			//에러일떄는 메시지 보여주고 로그인화면으로 다시감
			return mav;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			mav.addObject("message", util.getMessage("all.process.fail",new String[]{"로그인을"}));
			mav.addObject("url", "./");
			
			mav.setViewName("alert-layout");
			logger.info("(((((((((((((NULLPOINTEREXCEPTION(진짜 널이거나 아이디가 없습니다.) END(method : login))))))))))))))))))");
		}
		//util.getMessage("tes.test");
		logger.info("((((((((((((("+getClass()+"END(method : login))))))))))))))))))");
		
		mav.addObject("message", util.getMessage("member.login",new String[]{form.getUser_Id()}));
		mav.addObject("url", "./boardList.jdk");
		mav.setViewName("alert-layout");
		return mav;
	}
	
	//로그아웃
	@RequestMapping(value = "/logout.jdk", method= RequestMethod.POST)
	public String logout(HttpSession session){
		logger.info("((((((((((((("+getClass()+"START(method : logout)))))))))))))))))");
		session.setAttribute("userInfo", null);
		logger.info("((((((((((((("+getClass()+"END(method : logout)))))))))))))))))");
		return "beforeLogin-layout";
	}
	
	/*****************************************************회원가입 시작******************************************************************/
	//회원가입으로 이동
	@RequestMapping(value = "/newMemberJoinMove.jdk", method = RequestMethod.GET)
	public String memberJoinMove(Model model) {
		logger.info("((((((((((((("+getClass()+"START(method : memberJoinMove)))))))))))))))))");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("title", "jdk\'s homepage newMemberPage");
		mav.setViewName("newMemberJoin-layout");
		
		logger.info("((((((((((((("+getClass()+"END(method : memberJoinMove))))))))))))))))))");
		return "newMemberJoin-layout";
	}
	
	//회원가입
	@RequestMapping(value = "/newMemberJoin.jdk", method = RequestMethod.POST)
	public ModelAndView memberJoin(@ModelAttribute("memberVO")MemberVO form, ModelAndView model, HttpSession session) {
		logger.info("((((((((((((("+getClass()+"START(method : memberJoin)))))))))))))))))");
		
		try {
			service.memberInsert(form);
			if(service.memberCount(form) <= 0){
				logger.info("(((((((((((((NULLPOINTEREXCEPTION(가입에 실패하였씁니다.) END(method : memberJoin))))))))))))))))))");
				model.addObject("message", util.getMessage("all.process.fail",new String[]{"가입을"}));
				model.addObject("url", "./newMemberJoinMove.jdk");
				model.setViewName("alert-layout");
				return model;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("(((((((((((((가입에 실패하였씁니다.)))))))))))))))))");
			model.addObject("message", util.getMessage("all.process.fail",new String[]{"가입을"}));
			model.addObject("url", "./newMemberJoinMove.jdk");
			model.setViewName("alert-layout");
			return model;
		}
		
		session.setAttribute("userInfo", null);
		logger.info("((((((((((((("+getClass()+"END(method : memberJoin))))))))))))))))))");
		model.addObject("message", util.getMessage("all.process.success",new String[]{"가입"}));
		model.addObject("url", "./");
		model.setViewName("alert-layout");
		return model;
	}
	/*****************************************************회원가입 끝******************************************************************/
	
	/*****************************************************회원찾기 시작******************************************************************/
	//로그찾기이동
	@RequestMapping(value = "/memberFindMove.jdk", method= RequestMethod.GET)
	public String memberFindMove(HttpSession session){
		logger.info("((((((((((((("+getClass()+"START(method : memberFindMove)))))))))))))))))");
		session.setAttribute("userInfo", null);
		logger.info("((((((((((((("+getClass()+"END(method : memberFindMove)))))))))))))))))");
		return "findMemberFindMove-layout";
	}
		
	//회원찾기
	@RequestMapping(value = "/memberFind.jdk", method = RequestMethod.POST)
	public ModelAndView memberFind(@ModelAttribute("memberVO")MemberVO form, ModelAndView model, HttpSession session) throws Exception {
		logger.info("((((((((((((("+getClass()+"START(method : memberFind)))))))))))))))))");
		MemberVO vo = service.memberFind(form);
		try {
			if(service.memberCount(form) <= 0){
				logger.info("(((((((((((((NULLPOINTEREXCEPTION(찾으시는 아이디가 존재하지 안습니다.) END(method : memberFind))))))))))))))))))");
				model.addObject("message", util.getMessage("notMember.find"));
				model.addObject("url", "./memberFindMove.jdk");
				model.setViewName("alert-layout");
				return model;
			}
			logger.info("((((((((((((("+getClass()+"START(method : sendMail)))))))))))))))))");
			mailUtil.sendMail(vo,logger);
			logger.info("((((((((((((("+getClass()+"END(method : sendMail)))))))))))))))))");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("(((((((((((((회원이 존재하지 안습니다.)))))))))))))))))");
			model.addObject("message", util.getMessage("notMember.find"));
			model.addObject("url", "./memberFindMove.jdk");
			model.setViewName("alert-layout");
			return model;
		}
		
		session.setAttribute("userInfo", null);
		logger.info("((((((((((((("+getClass()+"END(method : memberFind))))))))))))))))))");
		return new ModelAndView("findMemberFind-layout","findResult",vo);
	}
	/*****************************************************회원찾기 끝******************************************************************/
}
