package com.kh.test.board.model.service;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardService {

	
	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	/** 게시글 삽입
	 * @param insertBoard
	 * @return
	 */
	int insert(Board insertBoard);

	/** 게시글 상세 조회
	 * @param no
	 * @return selectBoard
	 */
	Board selectBoard(int no);

}
