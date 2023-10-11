package com.log4j.general;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx = new Transaction();
		System.out.println("Before deposit method call");
		tx.deposit();
		System.out.println("Before withdrawal method call");
		tx.withdrawal();
		System.out.println("Before transfer method call");
		tx.transfer();

	}

}
