package com.chang.sharingresources;

public class StaticTest {

	public static String ss = "123";

	public static String getSs() {
		return ss;
	}

	public static void setSs(String ss) {
		StaticTest.ss = ss;
	}

	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		st1.setSs("234");
		System.out.println(st2.getSs());
		System.out.println(st3.getSs());
	}
}	
