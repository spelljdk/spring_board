package sql;

import java.util.ArrayList;

import com.jdk.vo.*;

public interface MapperMaster {
	
	//회원관리
    void memberInsert(MemberVO memverVO);	//가입
    MemberVO memberSelect(MemberVO memverVO); //로그인
    MemberVO memberIDFind(MemberVO memverVO); //회원찾기
    void deleteMember(String user_Id);			//탈퇴

    //게시판 관리
    BoardVO boardSelect(BoardVO boardvo);	//글목록
    int boardSelectCount(BoardVO boardvo);	//글게수
    BoardVO boardView(BoardVO boardvo);		//글보기
    void boardWriteInsert(BoardVO boardvo); //글쓰기
    void boardViewCount(BoardVO boardvo);	//조회수증가
    void boardUpdate(BoardVO boardvo);		//글수정
    void boardDelete(BoardVO boardvo);		//글삭제
}
