package com.company.day1.initMethod;

public class SomeBean {
	public SomeBean() {
	}
	
	public void init(){
		System.out.println("init");
	}
	public void close(){
		System.out.println("close");
	}
	public void print(){
		System.out.println("SomeBean print");
	}
}
