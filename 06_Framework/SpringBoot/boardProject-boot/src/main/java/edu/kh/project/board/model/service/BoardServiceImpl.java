package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;
import edu.kh.project.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class) // 모든 예외 발생시 롤백
@RequiredArgsConstructor // final 필드에 bean DI
public class BoardServiceImpl implements BoardService{

	private final BoardMapper mapper;
	
	
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		// 게시글 목록 조회에 페이지네이션(pagination 또는 페이징 처리)
		// 중요한 값 또는 객체
		// 1. 현재 몇 페이지 (cp)
		// 2. 게시판의 전체 게시글 수
		// 3. RowBounds 마이바티스 객체
		
		/* 전체 게시글 수 조회 */
		int listCount = mapper.getListCount(boardCode);
		/* cp, listCount를 이용해서 Pagination 객체 생성*/
		
		Pagination pagination = new Pagination(cp, listCount);
		
		/* RowBound 객체 생성
		 * 
		 * - RowBound?란
		 * - Row(행), bound(도약, 건너 뛰기)
		 * -- 전체 조회 결과 중 지정된 행(offset) 만큼 건너뛴 다음
		 * 	  읽어올 만큼
		 * 		 
		 *
		 */
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		int limit = pagination.getLimit();
		
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		   
		/* 마이바티스로 SQL 수행 시
		 * SQL에 전달 할 수 있는 파라미터의 개수는 1개 ( 첫번째 매개변수)
		 * 
		 * 두 번째 매개변수는 RowBounds만 가능
		 * */
		
		
		List<Board> boardList = mapper.selectBoardList(boardCode, rowBounds);
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardList);
		map.put("pagination", pagination);
		
		

		return map;
	}
	
	
	

	// 검색 목록 조회
	@Override
	public Map<String, Object> searchBoardList(Map<String, Object> paramMap, int cp) {
		
		/* 검색 조건 일치 게시글 수 조회 */
		int listCount = mapper.searchListCount(paramMap);
		
		/* cp, listCount를 이용해서 Pagination 객체 생성*/
		Pagination pagination = new Pagination(cp, listCount);
		
		/* RowBound 객체 생성
		 * 
		 * - RowBound?란
		 * - Row(행), bound(도약, 건너 뛰기)
		 * -- 전체 조회 결과 중 지정된 행(offset) 만큼 건너뛴 다음
		 * 	  읽어올 만큼
		 * 		 
		 *
		 */
		int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		int limit = pagination.getLimit();
		
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		List<Board> boardList = mapper.searchBoardList(paramMap, rowBounds);
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardList", boardList);
		map.put("pagination", pagination);
		
		
		return map;
	}
	
	
	
	
	// 게시글 상세 조회 + 게시글의 댓글 모두 조회
	@Override
	public Board boardDetail(Map<String, Object> map) {
		
		return mapper.boardDetail(map);
	}
	
	@Override
	public int likeCheck(Map<String, Object> map) {
		return mapper.likeCheck(map);
	}

	@Override
	public int like(Map<String, Object> paramMap) {
		
		int result = 0; // Mapper 호출 결과 저장 변수
		
		// 기존에 좋아요 한 상태 == check == 1
		// -> 좋하요 해제 == BOARD_LIKE 테이블에서 DELETE
		if( (Integer)( paramMap.get("check") ) == 1  ) {
			result = mapper.deleteBoardLike(paramMap);
			
		}else {
			result = mapper.insertBoardLike(paramMap);
		}
		
		// SQL 수행 결과가 0 == 파라미터에 문제 있음
		if(result == 0)return -1;
		
		// SQL 성공시
		// -> 현재 게시글의 좋아요 수를 조회해서 반환
		return mapper.countBoardLike( (Integer)(paramMap.get("boardNo") ) );
		
		// 기존에 좋아요 안한 상태 == check == 0
		// -> 좋아요 삽입 == BOARD_LIKE 테이블에서 INSERT
	}
	
	
	@Override
	public int updateReadCount(int boardNo) {
		
		return mapper.updateReadCount(boardNo);
	}
	
	
}
