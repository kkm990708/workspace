package edu.kh.network.ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server2 {

	public static void start() {
		int port = 8500;
		ServerSocket serverSocket = null;
		
		Socket clientSocket = null;
		
		InputStream is = null;	// 클라이언트 -> 서버 스트림
		OutputStream os = null; // 클라이언트 <- 서버 스트림
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			InetAddress inet = InetAddress.getLocalHost();
			System.out.println("서버 IP 주소 : " + inet.getHostAddress());
			
			serverSocket = new ServerSocket(port);
			
			System.out.println("[Server 입니다]");
			System.out.println("클라이언트의 접속을 기다리고 있습니다...");
				
			clientSocket = serverSocket.accept();
			
			System.out.println("[클라이언트 접속 성공]");
			
			is = clientSocket.getInputStream(); // 클라리언트 -> 서버 입력
			os = clientSocket.getOutputStream(); // 서버 -> 클라이언트 출력
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);

			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			
			String message = sdf.format(now) + "[서버 접속 성공]";
			
			pw.println(message);
			pw.flush();

			
			String ClientMessage = br.readLine();
			
			String ClientIP = clientSocket.getInetAddress().getHostAddress();
			
			System.out.println(ClientIP + "로부터 받은 메시지 : " + ClientMessage);
			
		} catch (Exception e) {
			
			
		} finally {
			
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				
				if(serverSocket != null) serverSocket.close();
				if(clientSocket != null) clientSocket.close();

				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
