package com.fastcampus.ch2;

public class Grade {
	private int e;// 영어 성적을 위한 변수
	private int m;// 수학 성적을 위한 변수
	
	public Grade() {
		
	}
	
	public Grade(int e, int m) {
		this.e = e;
		this.m = m;
	}
	
	void output_grade() {
		System.out.println( this.e + this.m );
	}
}
























