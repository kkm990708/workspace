package edu.kh.jsp.dto;

public class Book {

	private String title;
	private String writer;
	private int price;
	
	public Book() {}

	public Book(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getWrite() {
		return writer;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override // 오버라이딩 메서드 확인
	public String toString(){
		return String.format("%s / %s / %d", title, writer, price);
	}

}
