package edu.kh.network.ex2.thread;

import java.io.DataInputStream;
import java.net.Socket;

// 데이터를 수신하는 작업을 처리하는 스레디ㅡ
public class Receiver implements Runnable{
	private DataInputStream in = null;	
	// sander가 보낸 데이터를 받음 스트림
	public Receiver(Socket socket) {
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Override
	public void run() {
	
		while (true) {
			try {
				// Sender에서 출력한 UTF 문자열을 입력받아 화면에 출력
				System.out.println(in.readUTF());
			} catch (Exception e) {
				// 서버 또는 클라이언트 종료 시 입력 받을 수 없게 되면 예외 발생
				break;
			}
		}
		// TODO Auto-generated method stub
		
	}
}
