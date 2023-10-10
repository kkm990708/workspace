package edu.kh.project.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 라이브러리 : DTO 코드 자동완성

// 설정 방법
// 1) mvnrepository에서 lombok -> dependenct 추가(pom.xml)
// 2) lombok.jar 파일을 다운로드 받은 후 실행
// 		-> cmd -> java -jar 경로/lombok.jar
//		-> STS3 경로 설정 후 install

// 사용방법 
// - lombok에서 제공하는 어노테이션을 DTO 상단에 작성





//DTO (Data Transfer Object) : 데이터 전달용 객체
@NoArgsConstructor // 기본 생성자 자동완성
@Getter // getter 자동완성
@Setter // setter 자동완성
@ToString // ToString 자동완성
public class Member {

	private String memberEmail;
	private String memberPw;
	private String memberName;
	
	
	
}
