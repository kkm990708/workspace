package edu.kh.jdbc.service;

import java.io.Closeable;
import java.sql.Connection;

import static edu.kh.jdbc.common.JDBCTemplate.*;
// import static : 지정된 static 필드/메서드를 가져와서
//					해당 클래스 것 처럼 사용 가능하게함
//					--> 앞에 클래스명을 생략가능

import edu.kh.jdbc.model.dao.MemberDAO;
import edu.kh.jdbc.model.dto.Member;

// service : 비지니스 로직
// 요청에 따른 필요 데이터를 반환
// _ DB 연결 코드인 DAO를 호출
// 트랜잭션 제어 (commit, rollback
// -> commit , rollback을 하려던 Connection 이 필요하기 때문에
// Service 에서 connection 닫기/열기
public class MemberService {
	private MemberDAO dao = new MemberDAO();
	
	
	/** 회원가입 서비스
	 * 	 * @return
	 */
	public int insertMember(Member member) {
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 (커넥션, 매개변수 전달)
		// -> insert 성공한 행의 개수 반환
		int result = dao.inserMember(conn,member);
		
		// 3.성공여부에 따른 트랜잭션 제어
		if(result > 0 ) commit(conn);	// insert 성공
		else rollback(conn);	// insert 실패
		
		//사용 완료된 커넥션 반환
		close(conn);
		
		// sql 수행 결과를 view 반환
		return result;
	}


	
	/**
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {
		
		Connection conn = getConnection();
		
		// 2. DAO메서드 호출 (커넥션, 매개변수 전달)
		// -> update 성공한 행의 개수 반환
		int result = dao.updateMember(conn, member);
		
		// 3.성공여부에 따른 트랜잭션 제어
		// 성공(1) , 실패(0)
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 4.사용 완료된 커넥션 반환(close)
		close(conn);
		
		// 5. SQL 수행 결과를 view 반환
		return result;
	}



	public int deleteMember(Member member) {
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// dao에서 sql문 실행
		int result = dao.deleteMember(conn,member);
		
		// 트랜잭션 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 커넥션 반환
		close(conn);
		
		// 결과 반환
		return result;
	}



	public int updatePw(Member member, String chPw) {
		Connection conn = getConnection();
		int result = dao.updatePw(conn, member, chPw);
		
		//트랜잭션 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		// 커넥션 반환
		close(conn);
		
		return result;
	}

}
