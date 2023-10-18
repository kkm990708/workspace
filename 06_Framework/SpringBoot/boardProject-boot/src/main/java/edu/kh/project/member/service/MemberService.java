package edu.kh.project.member.service;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);

	int signup(Member inputMember, String[] memberAddress);

	/** 빠른 로그인 서비스
	 * @param memberEmail
	 * @return
	 */
	Member quickLogin(String memberEmail);

}
