package edu.kh.oop.basic;
	
// 국민 정보를 저장을 객체를 위한 설계도
public class Nation {
	
	// 속성
	String pNo; //주민등록번호
	String name;
	char gender;
	String address;
	String phone;
	int age;
	
	// 캡슐화 적용 : 불투명하게 처리
	// -> 외부 직접 접근을 차단해서 존재유무, 실제 데이터를 모르게하기(정보 은닉)
	private String jop;
	//private -> 현재 클래스 에서만 접근가능

	// 기능
	public void speakKorean() {
		System.out.println("가나다라 한국어 가능");
	}
	
	public void 납세의의무() {
		System.out.println("세금");
	}
	
	public void introduce() {// 자기소개 기능
		System.out.printf("저의 이름은 %s이고, 직업은 %s 입니다\n",name,jop);
	}
	
	// 캡슐화 원칙에 의해서
	// 직접 접근이 차단된 변수(필드)에
	// 값을 세팅하거나 얻어갈 수 있는 간접 접근 기능을 작성
	public void setJob(String job) {	// 전달된 값을 저장하는 변수
		this.jop = job;
	}
	
	public String getJob() {
		return jop;
	}
}	
