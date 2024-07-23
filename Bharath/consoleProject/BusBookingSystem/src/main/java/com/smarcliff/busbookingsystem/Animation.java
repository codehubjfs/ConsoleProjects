package com.smarcliff.busbookingsystem;

public class Animation implements Runnable{
	private int delay;
	private String message;
	
	
	public Animation(int delay, String message) {
		this.delay = delay;
		this.message = message;
	}


	@Override
	public void run() {
		printCode(message.length());
		System.out.print(" ".repeat(45)+"|");
		for(char ch:message.toCharArray()) {
			System.out.print(ch);
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("|");
		printCode(message.length());
		
	}
	
	private void printCode(int length) {
		System.out.println(" ".repeat(45)+"+"+"-".repeat(length)+"+");
	}
	
}
