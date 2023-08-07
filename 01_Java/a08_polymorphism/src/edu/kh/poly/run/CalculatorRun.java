package edu.kh.poly.run;

import edu.kh.poly.model.dto.Calculator;
import edu.kh.poly.model.dto.KMSCalculator;
import edu.kh.poly.model.dto.KMSCalculatorV2;

public class CalculatorRun {
	public static void main(String[] args) {
		KMSCalculator calculator = new KMSCalculator();
		// 1. 인터페이스는 객체 생성이 안됨
		// 2. 인터페이스는 부모 참조 변수가 될 수 있을까?
//		Calculator calc = new KMSCalculator();
		Calculator calc = new KMSCalculator();
		System.out.println(calc.pow(4, 3)); 
		System.out.println(calc.minus(4, 2));
		System.out.println(calc.plus(9, 5));
		System.out.println(calc.multi(12, 7));
		System.out.println(calc.div(40, 8));
		System.out.println(calc.div(40, 12));
		System.out.println(calc.areaOfCircle(2.5));
	}
}
