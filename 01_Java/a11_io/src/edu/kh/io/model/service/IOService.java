package edu.kh.io.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.Buffer;
import java.util.Scanner;

import edu.kh.io.model.dto.Member;

public class IOService {
	// Stream(스트림) : 데이터가 이동하는 통로 (기본적으로 단방향)
	// 바이트 기반 스트림
	// InputStream, OutputStream 최상위 인터페이스
	// 1byte 단위로 데이터를 입/출력 하는 스트림
	// 1byte 범위 문자열(아스키코드( 영어,숫자,특수문자)
	// 또는 이미지, 영상,오이도 등 문자가 아닌 파일/데이터
	
	// 문자 기반스트림
	// Reader,write 최상위 인터페이스
	// -2byte 단위로 데이터(문자)를 입/출력 하는 스트림
	// - 2byte 범위 문자열, 문자만 저장된 파일채팅, 인터넷 요청 시 데이터 저달 등에 애용
	

	// 절대경로: 절대적인 기준으로 부터 목표까지의 경로
	// 서울시 중구 남도문로 120 2층 KH정보 교육원
	// C:/workspace/01_Jaca/a10_io/byte
	
	// 상대 경로 : 임의의(현재위치) 기준으로 부터 목표 까지의 경로
	// KH정보 교육원 기준 우리은행 본점 까지의 경로 : 옆건물
	// 현재 프로젝트(a11_io)폴더가 현재 위치
	
	
	/**
	 * 바이트 기반 출력
	 */
	public void byteOutput() {
		// IO 관련 코드는 IOException 는 발생시킬 가능서아
		FileOutputStream fos = null;
		try {
			// byte 기반 파일출력 스트림 생성
			fos = new FileOutputStream("byte/byteTest.txt");	
			// byte 폴더 내부에 byteTest.txt 파일이 있으면 출력을 위해 연결하고
			// 연결이 없으면 파일을 만들어서 연결해라
			String content = "Hello Wolrd!!!\n"
							+"1234567890\n"
							+"!@#$%^&*()_~\n"
							+"자바 재밌다";
			for (int i = 0; i < content.length(); i++) { // 글자 수만큼 반복
				char ch = content.charAt(i);
				fos.write(ch);	// 한 글자씩 연결된 파일로 출력
			}

		} catch (IOException e) {
			e.printStackTrace(); // 예외가 발생한 메서드까지 출력
		} finally{	// 무조건 실행
			// 사용 완료된 스트림을 메모리에 반환하는 코드 작성
			// close() 코드
			try {
				if (fos != null) { fos.close();}
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * 문자 기반 파일출력
	 */
	public void charOutput() {
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("char/charTest.txt");
			// char 폴더의 char/charTest.txt 가 있으면 문자 출력 스트림 연결 없으면 만들어서 연결
			String content = "가나다라마바사\n"
							+"공부하세요\n"
							+"안녕하세요\n"
							+"히오스";
			fw.write(content);	// 문자열을 통째로 내보냄
			System.out.println("char 기반 출력완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				
				if (fw != null) {
					
					fw.close();	// fw 스트림 객체가 있을 때에만 메모리 닫기
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void byteInput() {
		FileInputStream fis =null;
		try {
			fis = new FileInputStream("노래가사/SuperShy.txt");
			// 읽어올 땐 한 글자씩 
			// 읽어온 한 글자를 저장할 변수 선언
			int value = 0; // byte(정수형)으로 읽어오는데 byte를 다루기 어려워서 int로 저장
			while (true) {
				value = fis.read();// 1byte 를 읽어와 int 로 저장 읽어올 내용이 없으면 -1 반환
				if (value == -1) {	// 다읽었으면 
					break;
				}
				System.out.print((char)value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(fis != null) { fis.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 문자기반 파일입력
	 */
	public void charInput() {
		FileReader fr =null;
		try {
			fr = new FileReader("노래가사/SuperShy.txt");
			// 읽어올 땐 한 글자씩 
			// 읽어온 한 글자를 저장할 변수 선언
			int value = 0; // byte(정수형)으로 읽어오는데 byte를 다루기 어려워서 int로 저장
			while (true) {
				value = fr.read();
				if (value == -1) {	// 다읽었으면 
					break;
				}
				System.out.print((char)value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(fr != null) { fr.close(); }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// file 복사하기
	public void fileCopy() {
		Scanner sc = new Scanner(System.in);
		// byte 기반 스트림 이용 + 성능 향상을 위한 보조 스트림
		// BufferedInputStream / BufferedOutputStream
		// -> 모아서 한번에 입출력
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			System.out.print("복사할 파일 경로 : ");
			String target = sc.nextLine();	// 한줄 입력
			System.out.print("복사본이 저장될 경로 + 파일명 : ");
			String copy = sc.nextLine();
			
			//복사 대상을 읽어올 IputStream 생성 + 보조 스트림으로 성능 향상
			bis = new BufferedInputStream(new FileInputStream(target));
			// 보조스트림( 기반 스트림 )
			// 복사한 파일을 출력할 OutputStream 생성 + 보조 스트림으로 성능향상
			bos = new BufferedOutputStream(new FileOutputStream(copy));
			int value = 0; // 1byte씩 읽어서 저장할 임시변수
			while (true) {
				value =bis.read();	// 1byte 읽어오기, 없으면 -1
				if (value == -1) break;
				// if,for,while {}안에 코드가 1줄이면 생략 가능
				bos.write(value); // 1byte씩 출력
				
			}
			System.out.println("복사완료");
			
			
		}catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 다쓴 스트림 없애기
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				// 보조스트림 close 하면 연결된 기반 스트림도 같이 close() 된다
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 객체 출력 보조스트림 이용
	 */
	public void objectOutput() {
		// ObjectOutputStream
		// -> 객체를 바이트 기반으로 출력하는 보조 스트림
		// 사용 조건 : 출력하는 객체에 직렬화 가능 여부를 나타내는 Serializable
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			// java.io.File : 파일/폴더를 참조하는 객체
			File folder = new File("Object");	//object라는 이름의 파일/폴더 참조
			if (!folder.exists()) {	// object폴더가 존재하지 않는다면
				folder.mkdir();	//make directory(folder) : 폴더만들기
			}
			oos = new ObjectOutputStream(new FileOutputStream("object/Member.txt"));
			// 내보낼 회원 객체 생성
			Member member = new Member("id01", "pw01", "name01", 1000);
			// 회원 객체를 파일로 출력
			oos.writeObject(member);
			System.out.println("회원 출력 완료");
			// NotSerializableException : 직렬화 안되있음
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (oos != null) oos.close(); //스트림닫기 (메모리반환)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 객체 입력 보조스트림 활용
	 */
	public void objectInput() {
		ObjectInputStream ois = null;
		try {
			// 파일내 객체를 읽어오는 스트림 생성
			ois = new ObjectInputStream(new FileInputStream("object/Member.txt"));
			Member member = (Member)ois.readObject(); // ois.readObject() : 직렬화된 객체를 읽어와 역직렬화
			System.out.println(member);
		} catch (Exception e) {
			// FileNotFoundException
			// IOException
			// 둘다 한번에 잡아서 처리
			// Exception : 모든 예외의 최상위 부모
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
