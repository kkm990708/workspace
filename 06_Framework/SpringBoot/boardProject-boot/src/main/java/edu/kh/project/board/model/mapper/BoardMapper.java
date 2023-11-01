package edu.kh.project.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param rowBounds 
	 * @return boardList
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);

	/** 전체 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	int getListCount(int boardCode);

	/** 게시글 상세 조회
	 * @param map
	 * @return
	 */
	Board boardDetail(Map<String, Object> map);

	/** 게시글 좋아요 여부 확인
	 * @param map
	 * @return
	 */
	int likeCheck(Map<String, Object> map);

	/** 좋아요 테이블에서 행 삭제
	 * @param paramMap
	 * @return result
	 */
	int deleteBoardLike(Map<String, Object> paramMap);

	/** 좋아요 테이블에서 행 삽입
	 * @param paramMap
	 * @return result
	 */
	int insertBoardLike(Map<String, Object> paramMap);

	/** 좋아요 수 조회
	 * @param boardNo
	 * @return
	 */
	int countBoardLike(Integer boardNo);

	/** 조회수 증가 
	 * @param boardNo
	 * @return return
	 */
	int updateReadCount(int boardNo);
	
	

}