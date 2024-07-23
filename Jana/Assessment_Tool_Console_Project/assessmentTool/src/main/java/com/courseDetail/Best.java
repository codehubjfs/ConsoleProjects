package com.courseDetail;

public class Best {

	public void run() {
		System.out.println("This is Parent");
	}
}

class Child extends Best{
	public void run() {
		System.out.println("This is Child");
	}
}

class driver{
	public static void main(String[] args) {
		Child c = new Child();
		c.run();
	}
}
