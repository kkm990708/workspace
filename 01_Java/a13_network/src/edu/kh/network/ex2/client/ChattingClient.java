package edu.kh.network.ex2.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;import javax.sound.sampled.Port;

import edu.kh.network.ex2.thread.Receiver;
import edu.kh.network.ex2.thread.Sender;

public class ChattingClient {

	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.print("접속할 IP : ");
		String serverIP = sc.next();
		System.out.print("포트번호 : ");
		int port = sc.nextInt();
		sc.hasNextLine();	// 입력 버퍼에 남아있는 문자 제거
		
		Socket socket = null;
				
		
		
		try {
			socket = new Socket(serverIP, port);
			if (socket != null) {	// 서버 접속 성공 시
				System.out.println("<< 서버 접속 성공 >>");
				System.out.print("클라이언트 이름 입력 : ");
				String clientName = sc.next();
				
				// 서버 <- 클라이언트 출력 역할 객체 생성
				Sender sender = new Sender(socket, clientName);
				
				// 서버 -> 클라이언트 입력 역할 객체 생성
				Receiver receiver = new Receiver(socket);
				
				Thread th1 = new Thread(sender);
				Thread th2 = new Thread(receiver);
				
				// 스레드로 생성
				th1.start();
				th2.start();
				// 스레드가 시작되면서 입력, 출력이 동시에 무한히 수행되는 서버 완성

				th1.join();	// 해당 스레드 종료시까지 현재 스레드 대기
				th2.join();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
				try {
					if(socket != null) socket.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
