package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample3 {
	public static void main(String[] args) {
		// 입력 받은 최소 급여보다 많이 받고 
		// 입력받은 최고 급여보단 적게 받는 
		// 사원의 사번, 이름, 급여, 직급명을 급여 내림차순 조회
		
		// [실행화면]
		// 최소급여 : 1000000
		// 최대급여 : 3000000
		
		// (사번) / (이름) / (급여)
		// (사번) / (이름) / (급여)
		// (사번) / (이름) / (급여)
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String type = "jdbc:oracle:thin:@";	// 드라이버 종류 
			String host = "115.90.212.20";	// DB서버 컴퓨터 IP 주소
			String port = ":10000";		// DB서버 컴퓨터 내에서 DB프로그램 번호
			String dbName = ":ORCL";	// DB 이름
			String userName = "a230724_kms_kang"; // 사용자 계정
			String pw = "kkm990708";	// 비밀번호
			
			conn = DriverManager.getConnection(type + host + port + dbName, userName , pw);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("최소 급여 : ");
			int min = sc.nextInt();
			System.out.print("최대 급여 : ");
			int max = sc.nextInt();
			
			String sql = "SELECT EMP_ID ,EMP_NAME ,SALARY , JOB_NAME\r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE SALARY BETWEEN "+min+" AND "+max+"\r\n"
					+ " ORDER BY SALARY DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %d / %s \n",
						empId, empName, salary, jobName);
			}
			
		} catch (Exception e) {
			
		} finally {
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
