package edu.kh.project.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	int info(Member updateMember);

	String selectMemberPw(int memberNo);

	int changePw(Map<String, Object> insertMember);

	/** 회원탈퇴
	 * @param loginMember
	 * @return
	 */
	int secession(Member loginMember);

	/** 프로필 이미지 수정
	 * @param loginMember
	 * @return result
	 */
	int profile(Member loginMember);

}
