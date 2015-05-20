package com.jdk.board.action;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jdk.board.service.BoardMasterService;
import com.jdk.mem.action.memberMainMoveAction;
import com.jdk.util.messageUtil;
import com.jdk.vo.BoardVO;
import com.jdk.vo.MemberVO;

@Controller
public class BoardListAction {
	@Autowired
	private BoardMasterService boardMasterService;
	private messageUtil util;
	
	public void setUtil(messageUtil util) {
		this.util = util;
	}

	static Logger logger = Logger.getLogger(BoardListAction.class);
	public void setBoardMasterService(BoardMasterService boardMasterService) {
		this.boardMasterService = boardMasterService;
	}
	/*게시판 리스트*/
	@RequestMapping(value="/boardList.jdk", method = RequestMethod.GET)
	public ModelAndView boardList_GET(ModelAndView model,HttpSession session){
		logger.info("((((((((((((("+getClass()+"START(method : boardList_GET))))))))))))))))))");
		try {
			BoardVO vo = new BoardVO();
			//total paging
			vo.setTotalPageCount(boardMasterService.boardSelectCount(vo));
			
			model.addObject("totalPageCount", pagingCount(vo.getTotalPageCount()));
			
			if(!session.getAttribute("userInfo").equals("") && vo.getTotalPageCount() >= 1){
				//nowPaging
				vo.setBoardCount("1");
				model.addObject("boardCount","1");
				
				vo.setStartBoard("0");
				vo.setEndBoard("3");
				model.addObject("boardList",boardMasterService.boardSelect(vo));
				model.setViewName("boardList-layout");
			}else
				model.setViewName("beforeLogin-layout");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model =  new ModelAndView("boardList-layout","boardList","");
		}
		
		logger.info("((((((((((((("+getClass()+"END(method : boardList_GET))))))))))))))))))");
		return model;
	}
	
	/*게시판 리스트*/
	@RequestMapping(value="/boardList.jdk", method = RequestMethod.POST)
	public ModelAndView boardList_POST(@ModelAttribute("boardVO")BoardVO boardVO,ModelAndView model,HttpSession session){
		logger.info("((((((((((((("+getClass()+"START(method : boardList_POST))))))))))))))))))");
		try {
			boardVO.setTotalPageCount(boardMasterService.boardSelectCount(boardVO));
			model.addObject("totalPageCount", pagingCount(boardVO.getTotalPageCount()));
			
			if(!session.getAttribute("userInfo").equals("") && !boardVO.getBoardCount().equals("0")){
				boardVO.setStartBoard(""+((Integer.parseInt(boardVO.getBoardCount())-1) * 3+1));
				boardVO.setEndBoard(""+(Integer.parseInt(boardVO.getBoardCount()) * 3));
				
				model.addObject("boardCount","1");
				model.addObject("boardList",boardMasterService.boardSelect(boardVO));
				model.setViewName("boardList-layout");
			}else
				model.setViewName("beforeLogin-layout");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model =  new ModelAndView("boardList-layout","boardList","");
		}
		
		logger.info("((((((((((((("+getClass()+"END(method : boardList_POST))))))))))))))))))");
		return model;
	}
	
	
	
	//페이징이 몇까지 나와야하는지 계산
	public int pagingCount(int totalPage){
		//한페이지당 게시글 3개씩
		int modResult = totalPage/3;
		if(totalPage%3 != 0){
			modResult++;
		}
		
		return modResult;
	}
	
	/*게시판 뷰보기*/
	@RequestMapping(value="/boardView.jdk", method = RequestMethod.POST)
	public ModelAndView boardView(@ModelAttribute("boardVO") BoardVO boardvo, ModelAndView model){
		logger.info("((((((((((((("+getClass()+"START(method : boardView))))))))))))))))))");
		try {
			boardMasterService.boardViewCount(boardvo);
			boardvo = boardMasterService.boardView(boardvo);
			model.addObject("boardvo", boardvo);
			model.setViewName("boardView-layout");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.setViewName("boardList-layout");
		}
		logger.info("((((((((((((("+getClass()+"END(method : boardView))))))))))))))))))");
		return model;
	}
	
	
	
	/*게시판 수정페이지*/
	@RequestMapping(value="/boardUpdateMove.jdk", method = RequestMethod.POST)
	public ModelAndView boardUpdateMove(@ModelAttribute("boardVO") BoardVO boardvo, ModelAndView model){
		logger.info("((((((((((((("+getClass()+"START(method : boardUpdateMove))))))))))))))))))");
			model.setViewName("boardUpdate-layout");
			model.addObject("boardVO", boardvo);
		logger.info("((((((((((((("+getClass()+"END(method : boardUpdateMove))))))))))))))))))");
		return model;
	}
	
	/*게시판 수정하기*/
	@RequestMapping(value="/boardUpdate.jdk", method = RequestMethod.POST)
	public ModelAndView boardUpdate(@ModelAttribute("boardVO") BoardVO boardvo, ModelAndView model){
		logger.info("((((((((((((("+getClass()+"START(method : boardUpdateMove))))))))))))))))))");
			try {
				boardMasterService.boardUpdate(boardvo);
			} catch (Exception e) {
				e.printStackTrace();
				model.setViewName("alert-layout");
				model.addObject("message", util.getMessage("all.process.fail",new String[]{"글수정"}));
				model.addObject("url", "./boardList.jdk");
				return model;
			}
		logger.info("((((((((((((("+getClass()+"END(method : boardUpdateMove))))))))))))))))))");
		model.setViewName("alert-layout");
		model.addObject("message", util.getMessage("all.process.success",new String[]{"글수정"}));
		model.addObject("url", "./boardList.jdk");
		return model;
	}
	
	
	
	/*게시판 삭제*/
	@RequestMapping(value="/boardDelete.jdk", method = RequestMethod.POST)
	public ModelAndView boardDelete(@ModelAttribute("boardVO") BoardVO boardvo, ModelAndView model){
		logger.info("((((((((((((("+getClass()+"START(method : boardDelete))))))))))))))))))");
		
		try {
			boardMasterService.boardDelete(boardvo);
		} catch (Exception e) {
			e.printStackTrace();
			model.setViewName("alert-layout");
			model.addObject("message", util.getMessage("all.process.fail",new String[]{"게시글 삭제를"}));
			model.addObject("url", "./boardList.jdk");
			return model;
		}
		
		logger.info("((((((((((((("+getClass()+"END(method : boardDelete))))))))))))))))))");
		model.setViewName("alert-layout");
		model.addObject("message", util.getMessage("all.process.success",new String[]{"글삭제"}));
		model.addObject("url", "./boardList.jdk");
		return model;
	}
	
	
	/*게시판 작성이동페이지*/
	@RequestMapping(value="/boardInsertMove.jdk", method = RequestMethod.GET)
	public ModelAndView boardInsertMove(ModelAndView model){
		logger.info("((((((((((((("+getClass()+"START(method : boardInsertMove))))))))))))))))))");
			model.setViewName("boardInsert-layout");
		logger.info("((((((((((((("+getClass()+"END(method : boardInsertMove))))))))))))))))))");
		return model;
	}
	
	/*글 삽입하기*/
	@RequestMapping(value="/boardInsert.jdk", method = RequestMethod.POST)
	public ModelAndView boardInsert(@ModelAttribute("boardVO") BoardVO boardvo, ModelAndView model,HttpSession session){
		logger.info("((((((((((((("+getClass()+"START(method : boardInsert))))))))))))))))))");
		MemberVO memberVo = (MemberVO) session.getAttribute("userInfo");
			try {
				boardvo.setBoardUserId(memberVo.getUser_Id());
				boardMasterService.boardInsert(boardvo);
			} catch (Exception e) {
				e.printStackTrace();
				model.setViewName("alert-layout");
				model.addObject("message", util.getMessage("all.process.fail",new String[]{"글작성을"}));
				model.addObject("url", "./boardList.jdk");
				return model;
			}
		logger.info("((((((((((((("+getClass()+"END(method : boardInsert))))))))))))))))))");
		model.setViewName("alert-layout");
		model.addObject("message", util.getMessage("all.process.success",new String[]{"글작성"}));
		model.addObject("url", "./boardList.jdk");
		return model;
	}
}
