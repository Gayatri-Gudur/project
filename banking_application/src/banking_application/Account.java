package banking_application;

import java.util.Scanner;

public class Account {
int balance;
int previousTransaction;
String CustomerName;
String CustomerID;

//class  constructor
Account(String cname,String cid){
	CustomerName=cname;
	CustomerID= cid;
}

//function for depositing money
void deposit(int amount){
if(amount !=0) {
	balance=balance+amount;
	previousTransaction =+amount;
}
}

//function for withdrawing amount
void withdraw(int amount) {
	if(amount !=0) {
		balance=balance -amount;
		previousTransaction =-amount;
	}
}

void getPreviousTransaction() {
	if(previousTransaction >0) {
		System.out.println("Deposited: "+previousTransaction);
	}else if(previousTransaction<0) {
		System.out.println("withdraw: "+Math.abs(previousTransaction));
	}
	else {
		System.out.println("No transaction occures");
	}
}

void calculateInterest(int years) {
	double interestRate=.0185;
	double newBalance=(balance + interestRate*years )+balance;
	System.out.println("The current interest rate is "+(100*interestRate)+"%");
	System.out.println("After "+years+" years, you balance will be: "+newBalance);
  }


void showmenu() {
	char option='\0';
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Welcome "+CustomerName+"!");
	System.out.println("Your ID is: "+CustomerID);
	System.out.println();
	System.out.println("What would you like to do ");
	System.out.println();
	System.out.println("A: Check your balance");
	System.out.println("B: Make a deposit");
	System.out.println("C: Make a withdrawl");
	System.out.println("D: View previous Transactions");
	System.out.println("E: Calculate Interest");
	System.out.println("F: Exit");
	
	do {
		System.out.println();
		System.out.println("Enter an option");
		char option1=sc.next().charAt(0);
		option=Character.toUpperCase(option1);
		System.out.println();
		
		switch (option) {
//		for checking balance
		case 'A':
//			System.out.println();
			System.out.println("===========================");
			System.out.println("Your current balance is Rs."+balance);
			System.out.println("===========================");
			System.out.println();
			break;

//		deposit
		case 'B':
			System.out.println("============================");
			System.out.println("Enter amount to deposit ");
			int amount1=sc.nextInt();
			deposit(amount1);
			System.out.println("============================");
			System.out.println();
			break;
			
			//withdraw 
		case 'C':
			System.out.println("============================");
			System.out.println("Enter amount to withdraw ");
			int amount2=sc.nextInt();
			withdraw(amount2);
			System.out.println();
			break;
			
//			View previous Transactions
		case 'D':
			System.out.println("============================");
		    getPreviousTransaction();
		    System.out.println("============================");
		    System.out.println();
		    break;
		    
		case 'E':
			System.out.println("============================");
		    System.out.println("Enter years ");
		    int years=sc.nextInt();
		    calculateInterest(years);
		    System.out.println("============================");
		    System.out.println();
		    break;
		    
		case 'F':
			System.out.println("============================");
			System.out.println();
		default:
			System.out.println("Error occured. Please enter A,B,C,D,E,F");
			break;
		}
	}
	while(option!='F');
		System.out.println("Thank you for banking with us ");
	
	
}
}
