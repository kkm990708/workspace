package edu.kh.model.service;

// static 필드/메서드 호출시 클래스명 생략
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;
import edu.kh.model.dao.ProjectDAO;

public class ProjectService {

	private ProjectDAO dao = new ProjectDAO();
	
	/** 회원 가입
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출(Connection, 매개 변수 전달
		int result = dao.insertMember(conn, member);
		
		// 3. 트랜잭션 제어
		if(result > 0)  commit(conn);
		else 			rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		return result;
	}

	/** 로그인 
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(String email, String pw) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출
//		Member member = dao.login(conn, email, pw);	// PreparedStatement
		Member member = dao.login2(conn, email, pw); // Statement
		
		// SELECT는 트랜잭션 제어 처리가 필요 없음 -> 건너 뜀
		
		// 3. 커넥션 반환
		close(conn);
		
		// 4. view로 결과 반환
		return member;
	}
	
	public List<Member> selectAllMember(int sort){
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		close(conn);
		
		return memberList;
	}

	/** 회원 정보 수정
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nickname, String tel, int memberNo) {
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, nickname, tel, memberNo);
		
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int updateDelFl(int memberNo, String pw) {
		Connection conn = getConnection();
		
		int result = dao.updateDelFl(conn, memberNo, pw);
		
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertBoard(String title, String content, int memberNo) {
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, title, content, memberNo);
		
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}

	public List<Board> selectBoardList() {
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList(conn);
		
		close(conn);
		
		return boardList;
	}

	public Board selectBoard(int boardNo) {
		
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo);
		
		if(board != null) {
			int result = dao.incrementReadCount(conn, boardNo);
			if(result > 0) 	{
				commit(conn);
				board.setReadCount(board.getReadCount() + 1);
			}
			else 			rollback(conn);
		}
		
		close(conn);
		
		return board;
	}

	public int findBoard(int memberNo, int boardNo) {
		Connection conn = getConnection();
		
		int result = dao.findBoard(conn, memberNo, boardNo);
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
		close(conn);
		return result;
	}

	public int updateBoard(int boardNo, String title, String content) {
		Connection conn = getConnection();
		
		int result = dao.updateBoard(conn, boardNo, title, content);
		
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
		return result;
	}

}
