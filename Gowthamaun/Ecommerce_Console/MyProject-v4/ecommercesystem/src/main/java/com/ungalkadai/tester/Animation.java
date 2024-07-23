package com.ungalkadai.tester;

public class Animation implements Runnable{
	private int delay;
	private String message;
	

	public Animation(int delay, String message) {
		super();
		this.delay = delay;
		this.message = message;
	}
	
	@Override
	public void run() {
		printLine(message.length());
		System.out.print(" ".repeat(75)+"|");
		for(char ch:message.toCharArray()) {
			System.out.print(ch);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("|");
		printLine(message.length());
	}
	
	private void printLine(int width) {
		System.out.println(" ".repeat(75)+"+"+"-".repeat(width)+"+");
	}

}
