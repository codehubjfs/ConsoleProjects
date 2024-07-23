package com.ungalkadai.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.ecommerce.customizedexceptions.InvalidMenuChoiceException;
import com.ecommerce.customizedexceptions.Validation;
import com.ecommerce.menu.AdminActivity;
import com.ecommerce.menu.CustomerActivity;
import com.ecommerce.menu.SellerActivity;
import com.ecommerce.users.Customer;
import com.ecommerce.users.account.Account;

public class UngalKadaiTester {
	public static void main(String[] args) {
		String msg = "W E L C O M E   T O   E C O M M E R C E   S T O R E";
		Thread animatedWelcome = new Thread(new Animation(60,msg));
		animatedWelcome.start();
		try {
			animatedWelcome.join();
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		startMenu();
				
	}
	
	public static void startMenu() {
		boolean flag = true;
		int choice=0,confirmation = 0;
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(System.in));
			//System.out.println();
			while(true){
				System.out.println("+----------------------------------+");
		        System.out.println("|              USERS               |");
		        System.out.println("+----------------------------------+");
		        System.out.println("| 1. Customer                      |");
		        System.out.println("| 2. Admin                         |");
		        System.out.println("| 3. Seller                        |");
		        System.out.println("| 4. Guest                         |");
		        System.out.println("| 5. Exit                          |");
		        System.out.println("+----------------------------------+");
			    System.out.println("Enter your choice");
				try {
				choice = Integer.parseInt(reader.readLine().trim());
				choice = Validation.isOptionValid(1, 5, choice);
				}catch(InvalidMenuChoiceException e) {
					System.out.println(e.getMessage());
					continue;
				}catch(NumberFormatException e) {
					System.out.println("Input should be a number.The letter or symbols are not allowed");
					continue;
				}
				switch(choice) {
					case 1:{
						CustomerActivity.doAuthentication();
						//return;
						break;
					}
					case 2:{
						AdminActivity.doAdminAuthentication();
						break;
						//return;
					}
					case 3:{
						SellerActivity.doSellerAuthentication();
						break;
					}
					case 4:{
						System.out.println("Page under developement........we will get back to you soon");
						break;
					}
					
					case 5:{
						flag = true;
						do {
							System.out.println("You have choosen to exit!!!");
							System.out.println("+----------------------------------+");
							System.out.println("|   Are you sure to Exit?          |");
							System.out.println("|  (1-yes | 0-no)                  |");
							System.out.println("+----------------------------------+");
							System.out.println("Enter your choice");
							try {
								confirmation = Integer.parseInt(reader.readLine().trim());
								confirmation = Validation.isOptionValid(0, 1, confirmation);
							}catch(NumberFormatException e) {
								System.out.println("Input should be a number.The letter or symbols are not allowed");
								continue;
							}catch(Exception e) {
								System.out.println(e.getMessage());
								continue;
							}
							if(confirmation==1) {
								System.out.println("Thanks for visiting  Have a Nice day :)");
								System.exit(0);
							}
							else if(confirmation==0) {
								flag = false;
							}
							}while(flag);
						break;
					}
				}
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

