package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.sound.sampled.Port;

public class JDBCExample {
	public static void main(String[] args) {
		
		//JDBC : JAVA에서 DB에 접근할 수 있게 해주는
		// 		 JAVA 제공코드(interface, class
		//			-> java.sql 패키지에 존재
		
		// EMPLYEE 테이블에서
		// 사번, 이름, 부서코드 직급코드 ,급여, 입사일에서
		// 자바 프로그램 얻어와 콘솔에 출력하기
		
		
		// 1.JDBC 객체 참조 변수 선언
		
		// Connection
		// 특정 데이터베이스와의 연결정보를 저장한 객체 
		// == dbeaver에서 DB 연결하기 위해 주소, 계정 정보 저장한 것과 같음
		Connection conn = null;	
		
		// Statement 
		// SQL을 String 형태로 전달하여 수행결과를 반환받음
		Statement stmt =null;
		
		// ResultSet
		// SELECT 수행 결과를 저장하는 객체
		// -> 조회 결과는 0행 이상(없을 수도 있다)
		// 커서라는 것을 이용해서 1행씩만 접근 가능
		ResultSet rs = null;
		
		try {
			// 2.Drivce를 이용해 Connection 객체 생성
			
			// 2-1) Oracle JDBC driver 객체를 메모리에 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName(클래스명) : 클래스를 읽어서 메모리 등록(객체화)
			// -> Oracle JDBC driver 를 객채로 만들면
			// 	  자동으로 DriverManager가 참조하도록 코드가 만들어져 있음
			
//			+ "// 2-2) DB연결 정보를 이욯해서 Connection 객체 생성\r\n"
//			+ "			String type = \"jdbc:oracle:thin:@\";	// 드라이버 종류 \r\n"
//			+ "			String host = \"115.90.212.20\";	// DB서버 컴퓨터 IP 주소\r\n"
//			+ "			String port = \":10000\";		// DB서버 컴퓨터 내에서 DB프로그램 번호\r\n"
//			+ "			String dbName = \":ORCL\";	// DB 이름\r\n"
//			+ "			String userName = \"a230724_kms_kang\"; // 사용자 계정\r\n"
//			+ "			String pw = \"kkm990708\";	// 비밀번호\r\n"
//			+ "			//
			
			// 2-2) DB연결 정보를 이욯해서 Connection 객체 생성
			String type = "jdbc:oracle:thin:@";	// 드라이버 종류 
			String host = "115.90.212.20";	// DB서버 컴퓨터 IP 주소
			String port = ":10000";		// DB서버 컴퓨터 내에서 DB프로그램 번호
			String dbName = ":ORCL";	// DB 이름
			String userName = "a230724_kms_kang"; // 사용자 계정
			String pw = "kkm990708";	// 비밀번호
			//
			
			
			// DriverManager: Connection 만드는 객체
			conn = DriverManager.getConnection(type + host + port + dbName, userName , pw) ;
			// -> 어떤 타입의 어디에있는 DB와 어떤 계정으로 연결할지에 대한
			// 연결 방법을 저장한 Connection 객체 생성 
			
			
			// Connection 객체 생성 확인( 오류 안나면 오타 없이 작성한 것!)
			// System.out.println(conn);
			
			// 3. SQL 작성
			String sql= "SELECT EMP_ID ,EMP_NAME ,DEPT_CODE ,JOB_CODE ,SALARY, HIRE_DATE  "
					+ "FROM EMPLOYEE";
			// 이 SQL 끝에 작성되면 "SQL 명령어가 올바그게 종료되지 않앗습니다 오륩
			
			// 4. Statement 객체 생성
			// - SQL 을 DB로 가져다주고, 결과를 다시 JAVA로 가져오는 객체
			stmt = conn.createStatement();
			
			
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			// executeQuery :SELECT 문을 수행하고 결과집합(resultSet)을 반환
			// executeUpdate : DML을 수행하고 결과 행의 수 반환
			rs = stmt.executeQuery(sql);
			
			// 6. SQL(SELECT) 결과가 담겨잇는 ResultSet(rset)를
			// 한 행씩 반복 접근하여 각 행의 컬럼 값을 얻어와 출력
			while (rs.next()) {
				// rs.next() : 한 행씩 이동해서 있으면 true, 업승면 false
				
				// rs.get자료형(컬럼명|컬럼순서);
	            // [Java]         [DB]
	            // String         CHAR, VARCHAR2
	            // int, long      NUMBER (정수만)
	            // float, double   NUMBER (실수만)
				
				// 지정된 컬럼의 값을 JAVA 자료형으로 변환해서 가져오기
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				
				int salary = rs.getInt("SALARY");
				// java.sql.Date : DB의 DATE 타입을 나타내는 객체
				Date hireDate = rs.getDate("HIRE_DATE");
				
					
				System.out.printf("사번 : %s / 이름 : %s / "
						+ "부서코드 %s / 직급코드 : %s / "
						+ "급여 : %d / 입사일 : %s \n",
						empId, empName, deptCode, jobCode, salary, hireDate.toString());
			}	// while 종료
			
			
		} catch (SQLException e) {
			// SQLException : JDBC 관련 최상위 예외
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// ClassNotFoundException : 오라클 JDBC 드라이버 없을때 발생
			// -> 경로 오타 또는 라이브러리 추가 X
			e.printStackTrace();
		} finally {
			// 7. 사용한 JDBC 객체 자원 반환(역순으로)
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
}
