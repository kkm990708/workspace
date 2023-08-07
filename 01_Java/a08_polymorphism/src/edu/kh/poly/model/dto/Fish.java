package edu.kh.poly.model.dto;

public class Fish extends Animal{
	private int gill; // 아가미 수

	public Fish() {
		// super(); 컴파일러가 자동으로 추가
	}
	
	
	public Fish(String type, String eatType, int gill) {
		super(type, eatType);
		this.gill = gill;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + gill;
	}

	public int getGill() {
		return gill;
	}

	public void setGill(int gill) {
		this.gill = gill;
	}
	
	@Override
	public void breath() {
		System.out.println("물고기는 아가미로 호흡한다");
	}
	
}
