package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample2 {
	public static void main(String[] args) {
		// 입력받은 급여보다 많이 받는 사원의
		// 사번, 이름, 급여, 직급명을 내림차순 조회 
		
		// 1.JDBC 객체 참조 변수 선언
		// 1.)
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2.) Drivce를 이용해 Connection 객체 생성
			
			// 2-1) Oracle JDBC driver 객체를 메모리에 로드
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";
			String host = "115.90.212.20";
			String port = ":10000";
			String dbName = ":ORCL";
			String userName = "a230724_kms_kang";
			String pw = "kkm990708";
			
			// DriverManager: Connection 만드는 객체
			conn = DriverManager.getConnection(type + host + port + dbName, userName , pw) ;
			
			// 3. SQL 작성 
			// \r\n = 엔터 (신경 X)
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("급여 입력 : ");
			int input = sc.nextInt();
			String sql = "SELECT EMP_ID ,EMP_NAME ,SALARY , JOB_NAME\r\n"
						+ "FROM EMPLOYEE\r\n"
						+ "JOIN JOB USING(JOB_CODE)\r\n"
						+ "WHERE SALARY >= "+input+"\r\n"
						+ "ORDER BY SALARY DESC";
			
			//4. Statment 객체 생성
			stmt = conn.createStatement();
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			// SELECT 수행하면 ResultSet 반환
			rs = stmt.executeQuery(sql);
			
			// 6. SQL(SELECT) 결과가 담겨있는 ResultSet(rs)을
			// 한 행씩 반복 접근하며 각 행의 컬럼 값을 얻어와 출력
			while (rs.next()) {
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %d / %s \n",
						empId, empName, salary, jobName);
			} // while 종료
			
			
		} catch (Exception e) {
			// Exception : 모든 예외의 최상위 부모
			// -> 다형성(업캐스팅) 을 이용해서 모든 자식예외를 잡아서 처리
			
		} finally {
			// 7. JDBC 객체 자원 반환(역순)
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
