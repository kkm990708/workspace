package edu.kh.variable;

public class Practice {
	public static void main(String[] args) {
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum1 / iNum2);
		System.out.println((int)dNum);
		System.out.println(iNum1 * dNum);
		System.out.println((double)iNum1);
		System.out.println((int)fNum);
		System.out.println((int)(iNum1 / fNum));
		System.out.println(iNum1 / fNum);
		System.out.println(iNum1 / (double)fNum);
		System.out.println((int)ch);
		System.out.println(iNum1 + ch);
		System.out.println((char)(iNum1 + ch));
		// & : 앰퍼센트 , | : 버티칼 바
	}
}
