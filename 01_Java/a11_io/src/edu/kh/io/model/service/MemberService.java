package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.io.model.dto.Member;

public class MemberService {
	private List<Member> membersList = null;
	public MemberService() {
		
		// 외부 파일에 작성된 객체(List<Member>)를 읽어와
		// memberList에 대입하는 코드
		// FileInputStream, ObjectInputStram 사용
		
		ObjectInputStream ois = null;
		try {
			// 파일이 있으면 읽어와 저장된 객체(List<Member)를 memberList 에 저장
			ois = new ObjectInputStream(new FileInputStream("Object/memberList.txt"));
			membersList = (List<Member>)ois.readObject();
						 // 다운캐스팅
			
		} catch (FileNotFoundException e) {
			System.out.println("[[ memberList.txt 파일이 존재하지 않습니다 ]]");
			
			membersList = new ArrayList<Member>(); // 비어있는 리스트를 memberList 
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e2) {
			}
		}
	}
	
	
	
	
	/** 회원목록 반환service
	 * @return memberList
	 */
	public List<Member> selectAll(){
		return membersList;
	}

	
	
	/**	회원 가입 서비스
	 * @param id
	 * @param pw
	 * @param name
	 * @param point
	 * @return
	 */
	public boolean sighUp(String id, String pw, String name, int point) {
		// id 중복인경우
		
		for(Member member : membersList) {
			if(member.getId().equals(id))
			return false;
		}
		
		// --------------------------------------
		
		// 중복 아닌경우
		
		// 1. 전달받은 값을 이용해 Member객체 생성 후 memberList에 추가
		membersList.add(new Member(id, pw, name, point));
		
		// 2. 회원이 추가된 memberList를 memberList.txt. 파일로출력
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream("Object/memberList.txt"));
			oos.writeObject(membersList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(oos !=null) oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return true;
	}

	/** 아이디/비밀번호 일치회원 반환 서비스
	 * @param id
	 * @param pw
	 * @return 일치하면 Member 객체 주소 / 없으면 null
	 */
	public Member selectOne(String id, String pw) {
		for(Member member : membersList) {
			if (member.getId().equals(id) && member.getPw().equals(pw)) {
				return member;
			}
		}
		return null;
	}




	public void changePw(Member member, String chPw) {
		member.setPw(chPw);
		reWrite();
	}

	
	private void reWrite() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("Object/memberList.txt"));
			oos.writeObject(membersList);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos !=null) oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




	public void removeAc(Member member) {
		membersList.remove(member);
		reWrite();
	}
	
	
}
