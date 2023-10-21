package com.kh.test.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper
public interface BoardMapper {

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
	 * @return
	 */
	Board selectBoard(int no);

	/** 게시글 비밀번호 조회
	 * @param boardNo
	 * @return
	 */
	String selectBoardPw(int boardNo);

	/** 게시글 삭제
	 * @param boardNo
	 * @return
	 */
	int deleteBoard(int boardNo);
 
	/** 게시판 업데이트
	 * @param updateBoard
	 * @return
	 */
	int updateBoard(Board updateBoard);
	
}
