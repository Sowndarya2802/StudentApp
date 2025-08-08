package in.pentagon.studentapp.index;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("Welcome to Student Application!");
		do { 
			System.out.println("1. Signup");
			System.out.println("2. Login");
			System.out.println("3. Forgot Password");
			System.out.println("4. Exit");
			choice=sc.nextInt();
			switch(choice) {
			case 1: Signup.signup();
			break;
			case 2: Login.login();
			break;
			case 3: Password.forgot();
			break;
			case 4:  System.out.println("Application closed..!");
			break;
			default: System.out.println("invalid choice,please enter the valid choice");
			
			}		
		}while(choice!=4);
		
		}
	}


