package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dto.Member;

// DAO (Data(Database) Access Object ) : 데이터베이스 접근 개체
// JDBC를 이용해서 DB에 SQL을 전달하여 수행후 결과를 반환 받는 역랄
public class MemberDAO {

	// 필드
	// JDBC 객체 참조변수 선언 (Connection 은 service에서 생성 -> 제외)
	private Statement stmt = null;
	private Statement rs = null;
	
	// 외부 변수 값을 SQL에 받아드림(삽입할_ 준비가 되었지 않은 satament  )
	// -> 성능. 속도 면에서 우위를 가지고 있음
	
	// -? (placeholder) : 변수를 위치시킬 자리 선정)
	private PreparedStatement pstmt = null;
	
	
 public int inserMember(Connection conn, Member member) { 
	 
	// 1. JDBC 객체 참조 변수 선언 -> 필드에 작성 완료
     // 2. DriverManager를 이용해 Connection 객체 생성
     //      -> Service에서 만들어서 전달 받음
	 
	 // --------------------------
	 // DAO 작성법
	 // 1. 최종 결과를 저장할 변수 또는 변수선언 또는 객체 생성
	 int result = 0;
	 
	 // 1) statement를 이용해서 수행할 sql 작성 -> 작성이 어려움
	 // -> statement의 자식인 preparedStatement 
	 
	 
	 // 2) preparedStatment 용 sql 작성
	 String sql = "INSERT INTO MEMBER "
			 + "VALUES(SEQ_MEMBER_NO.NEXTVAL, "
			 + "? , ? , ? , ? , ? , DEFAULT, DEFAULT)";
	 	try {
	 		// 3) 
	 		// statement 와 다르게 생성시 sql을 매개 변수로 사용함
	 		// -> SQL을 생성할 때 전달하여 >에 값 대입을 준비함
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?(placeholder) 에 알맞은 값 대입
			// pstmt.set 자료형(순서,값)
			
			// ** pstmt.setString() 으로 문자열을 SQL에 대입하면
			// 자동으로 양쪽에 ''(홑따옴표)를 추가해준다 
			
			pstmt.setString(1, member.getMemberEmail());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			pstmt.setString(4, member.getMemberTel());
			pstmt.setString(5, member.getMemberAddress());
			
			// 5. SQL 수행 후 결과 반환받기
			result = pstmt.executeUpdate();	// 매개변수에 SQL 추가 x
			// 이미 pstmt 생성할 때 추가했기 때문에
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// PreparedStatment는 statement의 자식이다
			close(pstmt);
		}
		return result;
	}


/** 회원 정보 수정
 * @param conn
 * @param member
 * @return
 */
public int updateMember(Connection conn, Member member) {
	
	// 1. 최종 결과를 저장할 변수 선언 또는 객체 생성
	int result = 0; //DML 수행하면 행의 개수 (int형 반환)
	
	// 2. SQL 작성
	String sql = "UPDATE MEMBER \r\n"
			+ "SET MEMBER_NICKNAME = ?, \r\n"
			+ "MEMBER_TEL = ?, \r\n"
			+ "MEMBER_ADDRESS = ? \r\n"
			+ "WHERE MEMBER_EMAIL = ? \r\n"
			+ "AND MEMBER_PW  = ?";
	
	try {
		// 3. PreparedStatment 객체 생성
		pstmt = conn.prepareStatement(sql);
		// -> 세팅된 sql의 ?자리에 값 대입 준비
		
		// 4. ? (placeholder) 에 알맞은 값 댕비
		pstmt.setString(1, member.getMemberNickname());
		pstmt.setString(2, member.getMemberTel());
		pstmt.setString(3, member.getMemberAddress());
		pstmt.setString(4, member.getMemberEmail());
		pstmt.setString(5, member.getMemberPw());
		
		// 5. SQL 수행 후 결과(결과 행의수) 확인 받기
		 result = pstmt.executeUpdate();
		
		
	} catch (Exception e) {
		
		
	} finally {
		try {
			close(pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 7. SQL 수행 결과 반환
	return result;
}


public int deleteMember(Connection conn, Member member) {
	int result = 0;
	
	// SQL문 작성
	String sql = "DELETE FROM MEMBER \r\n"
			+ "WHERE MEMBER_EMAIL = ?\r\n"
			+ "AND MEMBER_PW = ?";
	
	try {
		//  prepareStatement 생성
		pstmt = conn.prepareStatement(sql);
		
		// ?(placeholder) 에 값 대입
		pstmt.setString(1, member.getMemberEmail());
		pstmt.setString(2, member.getMemberPw());
		
		// sql 수행결과 반환
		result = pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {	// JDBC 객체 자원 반환
		try {
			
			close(pstmt);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	return result;
}


public int updatePw(Connection conn, Member member, String chPw) {
		
		int result = 0;
		
		String sql = "UPDATE MEMBER\r\n"
				+ "SET MEMBER_PW = ?\r\n"
				+ "WHERE MEMBER_EMAIL = ?\r\n"
				+ "AND MEMBER_PW = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chPw);
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPw());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				// 객체 반환
				close(pstmt);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// 결과 반환
		return result;
	}

}
