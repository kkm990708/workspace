package edu.kh.project.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override 
	public Member selectMember(String inputEmail) {
		
		return mapper.selectMember(inputEmail); 
	}
}