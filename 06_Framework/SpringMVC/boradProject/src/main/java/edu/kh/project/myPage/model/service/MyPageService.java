package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

// 인터페이스 사용 이유 : 규칙성 부여, 결합도 약화

/** 내 정보 수정 서비스
 * @author user1
 * @return result (1: 성공, 0 실패)
 */
public interface MyPageService {

	/** 내정보 수정 서비스
	 * @param updateMember
	 * @param memberAddress
	 * @return 1 : 성공 , 0 : 실패
	 */
	int info(Member updateMember, String[] memberAddress);

	/** 비밀번호 변경 서비스
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return 1 : 성공 , 0 : 실패
	 */
	int changePw(String currentPw, String newPw, int memberNo);

	
	/** 회원 탈퇴 서비스
	 * @param memberPw
	 * @param memberNo
	 * @return 1 : 성공 , 0 : 실패
	 */
	int secession(String memberPw, int memberNo);
	
}
