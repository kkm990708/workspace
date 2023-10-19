package edu.kh.project.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	/** 이메일이 일치하는 회원의 정보 조회
	 * @param inputEmail
	 * @return
	 */
	Member selectMember(String inputEmail);

	/** 전체 회원 조회
	 * @return
	 */
	
	// Mapper 메서드의 반환형이 List로 작성되어 있으면
	// 마이바티스 수행 시 조회되는 모든행을
	// 자동으로 List에 추가(add)
	// 단, 조회 결과가 없을경우 비어있는 List(0칸) 가 반환
	List<Member> selectAll();

	/** 전체 회원 조회(+ 정렬)
	 * @param query
	 * @return memberList
	 */
	List<Member> selectSort(String query);

	/** 회원 탈퇴 복구
	 * @param memberNo
	 * @return
	 */
	int restoration(int memberNo);

	/** 권한 변경
	 * @param memberNo
	 * @return
	 */
	int changeAuthority(int memberNo);

	/** 비밀번호 초기화
	 * @param map
	 * @return
	 */
	int   (Map<String, Object> map);
 
}
