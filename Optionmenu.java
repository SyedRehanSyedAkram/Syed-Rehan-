package MyATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Optionmenu extends Account {
	
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat =  new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	//Validate Login Information customer number and pin number
	int selection;	
	
	public void getLogin() throws IOException {
		int x = 1;
		
		do {
			try {
				data.put(7507574, 7507);
				data.put(727672, 7276);
				
				System.out.println("Welcome to Atm Project Developers!");
				System.out.println("Enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your pin Number: 	");
				setPinNumber(menuInput.nextInt());
			
			}catch(Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
				x = 2;
			}
		     for (Entry<Integer,Integer> entry : data.entrySet()) {
		    	 if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
		    	 getAccountType();
		    	 }
		     }
		     System.out.println("\n" + "Wrong customer or Pin" + "\n");
		}while(x == 1);
	}
	
	//Display account type menu with selection
	
		public void getAccountType() {
			System.out.println("Select the account that you want to access: ");
			System.out.println("Type 1 : Checking account");
			System.out.println("Type 2 : Saving account");
			System.out.println("Type 3 : Exit");
			System.out.println("Choice: ");
			
			selection =menuInput.nextInt();
			
			switch(selection) {
			case 1:
				getChecking();
				break;
			case 2:
				getSaving();
				break;
			case 3:
				System.out.println("Thank you for using this atm, Bye");
				break;
			
			default:
				System.out.println("\n" + "Invalid choice." + "\n");
				getAccountType();
			}
		}
	
		//Display checking account Menu with Selection
		
		public void getChecking() {
			System.out.println("Checking Account: ");
			System.out.println("Type 1 : View Balance");
			System.out.println("Type 2 : Withdraw Funds");
			System.out.println("Type 3 : Deposit Funds");
			System.out.println("Type 4 : Exit");
			System.out.println("Choice: ");
			
			selection =menuInput.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Saving Account balance : " + moneyFormat.format(getSavingBalance()));
				break;
			case 2:
				getCheckingWithdrawInput();
				getAccountType();
				break;
			case 3:
				getCheckingDepositInput();
				getAccountType();
				break;
			case 4:
				System.out.println("Thanks For using this ATM, bye.");
				break;
			default:
				System.out.println("\n" + "Invalid choice." + "\n");
				getSaving();
			}
		}
		
		
	
		
		//Display saving account with selection
		
		
		public void getSaving() {
			System.out.println("Saving Account: ");
			System.out.println("Type 1 : View Balance");
			System.out.println("Type 2 : Withdraw Funds");
			System.out.println("Type 3 : Deposit Funds");
			System.out.println("Type 4 : Exit");
			System.out.println("Choice: ");
			
			selection =menuInput.nextInt();
			
			switch(selection) {
			case 1:
				System.out.println("Checking Account balance : " + moneyFormat.format(getSavingBalance()));
				getAccountType();
				break;
			case 2:
				getSavingWithdrawInput();
				getAccountType();
				break;
			case 3:
				getSavingDepositInput();
				getAccountType();
				break;
			case 4:
				System.out.println("Thanks For using this ATM, bye.");
				break;
				
			default:
				System.out.println("\n" + "Invalid choice." + "\n");
				getChecking();
			}
		}
		
}
