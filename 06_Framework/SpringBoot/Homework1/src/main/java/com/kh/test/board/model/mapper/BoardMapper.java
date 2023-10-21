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

	
	
}
