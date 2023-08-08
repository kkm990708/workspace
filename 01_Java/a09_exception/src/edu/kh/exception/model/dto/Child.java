package edu.kh.exception.model.dto;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;

public class Child extends Parent{
	// 상속 
	@Override
	// 예외를 똑같이 쓰면 문제 없음
	// 예외의 범위를 넓계( 부모 예외)를 쓰면 문제 발생(불가능)
	// 예외의 개수를 다르개 쓰면
	// 1) 상속관계의 아닌 다른 예외 여러 개작성은 불가능
	// 2) 상속 관계의 자식 예외를 여러개 작성은 가능
	public void method() throws EOFException, DataFormatException{
		
	}
}
