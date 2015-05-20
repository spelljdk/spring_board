package com.jdk.vo;

import java.util.ArrayList;

import com.jdk.vo.BoardVO;

public class BoardVO {
	//로그인ID, 글번호, 글내용, 글제목, 글쓴날짜, 글내용,글쓴이
		private String userId;
		private String boardNo = "";
		private String boardContent;
		private String boardTitle;
		private String boardTime;
		private String boardCount;
		private String boardUserId;
		
		//검색모드, 검색어
		private String searchMode = "";
		private String searchContent ="";
		private ArrayList<BoardVO> boardList = null;
		
		//페이징
		private String nowPage;
		private String startBoard;
		private String endBoard;
		private int totalPageCount;	//전체글개수
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getBoardNo() {
			return boardNo;
		}
		public void setBoardNo(String boardNo) {
			this.boardNo = boardNo;
		}
		public String getBoardContent() {
			return boardContent;
		}
		public void setBoardContent(String boardContent) {
			this.boardContent = boardContent;
		}
		public String getBoardTitle() {
			return boardTitle;
		}
		public void setBoardTitle(String boardTitle) {
			this.boardTitle = boardTitle;
		}
		public String getBoardTime() {
			return boardTime;
		}
		public void setBoardTime(String boardTime) {
			this.boardTime = boardTime;
		}
		public String getBoardCount() {
			return boardCount;
		}
		public void setBoardCount(String boardCount) {
			this.boardCount = boardCount;
		}
		public String getBoardUserId() {
			return boardUserId;
		}
		public void setBoardUserId(String boardUserId) {
			this.boardUserId = boardUserId;
		}
		public String getSearchMode() {
			return searchMode;
		}
		public void setSearchMode(String searchMode) {
			this.searchMode = searchMode;
		}
		public String getSearchContent() {
			return searchContent;
		}
		public void setSearchContent(String searchContent) {
			this.searchContent = searchContent;
		}
		public ArrayList<BoardVO> getBoardList() {
			return boardList;
		}
		public void setBoardList(ArrayList<BoardVO> boardList) {
			this.boardList = boardList;
		}
		public String getNowPage() {
			return nowPage;
		}
		public void setNowPage(String nowPage) {
			this.nowPage = nowPage;
		}
		public String getStartBoard() {
			return startBoard;
		}
		public void setStartBoard(String startBoard) {
			this.startBoard = startBoard;
		}
		public String getEndBoard() {
			return endBoard;
		}
		public void setEndBoard(String endBoard) {
			this.endBoard = endBoard;
		}
		public int getTotalPageCount() {
			return totalPageCount;
		}
		public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
		}
		
		
}
