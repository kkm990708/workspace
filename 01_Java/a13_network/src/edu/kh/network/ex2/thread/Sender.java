package edu.kh.network.ex2.thread;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 데이터를 송신하는(출력하는) 
public class Sender implements Runnable{
	
	private String name;
	private Scanner sc = new Scanner(System.in);
	
	// DataOutputStream : 데이터를 기본자료형 또는 
	// UTF-8 문자열 단위로 출력하는 스트림
	private DataOutputStream out = null;
	
	public Sender(Socket socket, String name ) { //socket, name 매개변수
		try {
			this.name =name;
			out = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 쓰레드 시작
	@Override
	public void run() {
		while (true) {
			try {
				// UTF 8 형식의 문자열을 출력(자동 flush 처리)
				out.writeUTF(name + " > " + sc.nextLine());;
			} catch (Exception e) {
				// 출력을 받는 대상이 존재하지 안으않 예외 발생
				// -> 채팅 대상이 없으니 채팅을 종료
				break;
			}
		}
		
		
	}
	
}
