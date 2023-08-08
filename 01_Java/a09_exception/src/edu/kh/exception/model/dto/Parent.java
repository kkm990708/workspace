package edu.kh.exception.model.dto;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.zip.DataFormatException;

public class Parent {
	// 오버라이딩 시 예외처리 구문(throws) 작성 방법
	
	public void method() throws EOFException, DataFormatException{
		System.out.println("예외 처리 공부중");
	}
}
