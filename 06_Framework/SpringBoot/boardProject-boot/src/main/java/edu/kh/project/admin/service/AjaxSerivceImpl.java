package edu.kh.project.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.admin.mapper.AjaxMapper;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;

@Service
public class AjaxSerivceImpl implements AjaxSerivce{
	@Autowired
	private AjaxMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypr;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public String selectMemberNo(int memberNo) {
		
		return mapper.selectMemberNo(memberNo);
	}
	
	
	
	@Override
	public String selectEmail(String inputEmail) {
		
		return mapper.selectEmail(inputEmail);
	}

	
	@Override
	public Member selectMember(int no) {
		
		return mapper.selectMember(no);
	}
	
	
	@Override
	public List<String> selectEmailList(String keyword) {
		return mapper.selectEmailList(keyword);
	}
	
	@Override
	public List<Member> selectAll() {
		return mapper.selectAll();
	}
	
	
	@Override
	public int insertMember(Member member) {
		// 비밀번호 1234 를 암호화해서 member에 추가
		member.setMemberPw(bcrypr.encode("1234") );
		
		return memberMapper.signup(member);
	}
	
	
	@Override
	public int updateFlag(Map<String, Object> paramMap) {
		
		return mapper.updateFlag(paramMap);
	}
	
	
	
	
}