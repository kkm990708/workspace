package edu.kh.project.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.admin.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Transactional 
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override 
	public Member selectMember(String inputEmail) {
		
		return mapper.selectMember(inputEmail); 
	}
	
	@Override
	public List<Member> selectAll() {
		
		return mapper.selectAll();
	}
	
	@Override
	public List<Member> selectSort(int sort) {
		
		// sort 값에 따라 가공 처리
		String query = null;
		
		switch (sort) {
		case 1: query= "MEMBER_NO DESC"; break;
		case 2: query= "MEMBER_NO"; break;
		case 3: query= "MEMBER_EMAIL DESC"; break;
		case 4: query= "MEMBER_EMAIL"; break;
		}
		
		return mapper.selectSort(query);
	}
	
	
	@Override
	public int restoration(int memberNo) {
		return mapper.restoration(memberNo);
	}
	
	@Override
	public int changeAuthority(int memberNo) {
		return mapper.changeAuthority(memberNo);
	}
	
	
	@Override
	public int initPw(int memberNo) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberPw", bcrypt.encode("1234")) ;
		map.put("memberNo", memberNo);
		
		return mapper.initPw(map);
	}
	
}
