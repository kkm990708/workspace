package edu.kh.project.myPage.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Transactional
@Service
@PropertySource("classpath:/config.properties")
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Value("${my.member.webpath}")
	private String webpath;
	
	@Value("${my.member.location}")
	private String folderPath;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		// 주소 가공
		
		// 주소가 입력되지 않은 경우
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
		}
		
		// 주소를입력한 경우
		// 배열 -> 문자열로 합쳐서 inputMember에 추가
		else {
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}
		
		// mapper 호출 후 결과 반환
		return mapper.info(updateMember);
	}
	
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		
		String encPw = mapper.selectMemberPw(memberNo);
		
		if (!bcrypt.matches(currentPw, encPw)) {
			return 0;
		}
		
		// 3. 같으면 새 비밀번호 변경
		// 마이바티스 코드의 파라미터는 1개만 가능
		// -> 지금 newPw, memberNo 두개가 필요
		
		Map<String, Object>insertMember = new HashMap<>(); 
		insertMember.put("memberNo", memberNo);
		insertMember.put("memberPw", bcrypt.encode(newPw));
		
		return mapper.changePw(insertMember);
	}
	
	
	
	@Override
	public int secession(String memberPw, Member loginMember) {
		
		// 로그인한 회원의 암호화된 비밀번호 조회
		String encPw = mapper.selectMemberPw(loginMember.getMemberNo());
		
		if (!bcrypt.matches(memberPw, encPw)) {
			return 0;
		}
		
		//회원 탈퇴
		return mapper.secession(loginMember);
	}
	
	
	// 프로필 이미지 수정
	@Override
	public int profile(MultipartFile profileImg, Member loginMember) throws IllegalStateException, IOException {
		
		// 프로필 이미지 변경 대비
		String backup = loginMember.getProfileImg();
		
		// 변경된 파일명을 저장할 변수 선언
		// - 파일명 변경 이유 -> 파일명 같으면 이전 파일을 덮어 씌우기 때문에
		String rename = null;
		
		// (*중요*)업로드된 이미지가 있을 경우를 검사
		
		// 문자열 데이터 -> 데이터 != null (null을 이용해서 비교)
		
		// 파일 데이터 (업로드 안되어도 MultipartFile 객체가 생성됨)
		// -> 업로드된 파일의 크기를 이용해 비교
		// -> 파일.getSize() > 0
		
		if (profileImg.getSize() > 0) { // 업로드된 파일일 있다면
			
			// 1) 파일명 변경
			rename = Util.fileRename(profileImg.getOriginalFilename() );
			
			// 2) 바뀐 파일명 + 경로를 loginMember 세팅
			loginMember.setProfileImg(webpath +rename);
			
			// /images/member/121212112.jpg
			
		}else { // 업로드된 파일이 없다면 -> 기본 이미지로 변경
			loginMember.setProfileImg(null); // 이미지 제거
			
		}
		
		//mapper 호출 
		int result = mapper.profile(loginMember);
		
		// DB 업데이트 성공시 
		// 메모리에 임시 저장된 파일을 지정된 경로에 저장
		if(result > 0) {
			if(profileImg.getSize() > 0) { // 업로드 파일 있을 때
				
				// transfer : 옮기다, 갈아타다
				
				// 파일.transferTo(파일경로)
				// -> 메모리에 저장된 파일을 지정된 경로로 옮김(저장)
				
				profileImg.transferTo(new File(folderPath + rename) );
				// C:/workspace/project-resource/images/member/20231101010_10101.jpg
			}
		} else { // DB 업데이트 실패
			// loginMember에 backup 해둔 이미지를 세팅
			loginMember.setProfileImg(backup);
			
		}
		
		return result;
	}
	
	
	
	
}
