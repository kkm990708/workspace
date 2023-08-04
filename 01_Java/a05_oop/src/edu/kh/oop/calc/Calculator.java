package edu.kh.oop.calc;

	public class Calculator {
	private final double PI = 3.14592;
	private final int Max_VALUE = 1_000_000_000;
	private final int MIN_VALUE = - 1_000_000_000;
	private double saveValue; // 값 저장용 필드

	public void setSaveValue(double saveValue) {
		this.saveValue = saveValue;
	}
	
	public double getSaveValue() {
		return saveValue;
	}
	
	public double plus(double number) {
		saveValue += number;
		return saveValue;
	}
	
	public double minus(double number) {
		saveValue -= number;
		return saveValue;
	}
	
	public double multi(double number) {
		saveValue *= number;
		return saveValue;
	}
	
	public double div(double number) {
		if (number == 0) {
			saveValue = 0;
			return saveValue;
		}
		// 0인 경우 saveValue를 0으로 만든 후
		// 0 return 후 메소드 종료
		saveValue /= number;
		return saveValue;
	}
	
	public double init() {	// 초기화
		saveValue = 0;
		return saveValue;
	}
	
	public double changeMaxValue() {
		saveValue = Max_VALUE;
		return saveValue;
	}
	
	public double changeMinValue() {
		saveValue = MIN_VALUE;
		return saveValue;
	}
	
	// 원의 넓이
	public double circleArea(double r) {
		saveValue = PI * r * r;
		return saveValue;
	}
}
