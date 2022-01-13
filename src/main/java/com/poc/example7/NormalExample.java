package com.poc.example7;

public class NormalExample implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("without lambda expression " + i);
		}
	}

}
