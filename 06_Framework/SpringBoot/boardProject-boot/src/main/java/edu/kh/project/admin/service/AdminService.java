package edu.kh.project.admin.service;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	/** 계정 정보 찾기
	 * @param inputEmail
	 * @return
	 */
	Member selectMember(String inputEmail);

}
