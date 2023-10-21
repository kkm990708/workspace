package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;


@Transactional
@Service
public class BoardServicImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public List<Board> selectBoardList() {
		return mapper.selectBoardList();
	}
	
	@Override
	public int insert(Board insertBoard) {
		
		insertBoard.setBoardPw(bcrypt.encode(insertBoard.getBoardPw()));
		
		return mapper.insert(insertBoard);
	}
	
	
	@Override
	public Board selectBoard(int no) {
		
		return mapper.selectBoard(no);
	}
	
	
	@Override
	public int deleteBoard(int boardNo, String boardPw) {
		
		String encPw = mapper.selectBoardPw(boardNo);
		
		if (!bcrypt.matches(boardPw, encPw)) {
			return 0;
		}
		
		return mapper.deleteBoard(boardNo);
	}
	
	
	
	@Override
	public Board moveBoard(int boardNo, String boardPw) {
		String encPw = mapper.selectBoardPw(boardNo);
		
		if (!bcrypt.matches(boardPw, encPw)) {
			return null;
		}
		
		return mapper.selectBoard(boardNo);
	}
	
	@Override
	public int updateBoard(Board updateBoard) {
		
		updateBoard.setBoardPw(bcrypt.encode(updateBoard.getBoardPw() ) );
		
		return mapper.updateBoard(updateBoard);
	}
	
	
}
