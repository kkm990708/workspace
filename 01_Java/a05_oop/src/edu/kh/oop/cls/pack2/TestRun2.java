package edu.kh.oop.cls.pack2;
import edu.kh.oop.cls.pack1.ClassTest1;

public class TestRun2 {
	// classTest1 객체 생성
	// -> 다른 패키지
	// 패키지가 다른 클래스를 접근하고자 할 때
	// import라는 작업을 해서 가져와 사용
	ClassTest2 c2 = new ClassTest2(); 
	// dafault 접근제한자 : 같은 패키지에서 사용 가능
	// 같은 패키지는 import 필요 없음
	
}
