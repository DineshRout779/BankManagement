package packages;

import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		String name, id;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer name:");
		name = scanner.next();
		System.out.println("Enter customer id:");
		id = scanner.next();

		if (name.length() == 0 && id.length() == 0) {
			System.out.println("Please enter name and id");
		} else {
			BankAccount obj = new BankAccount(name, id);
			obj.showMenu();
		}
		scanner.close();
	}

}

class BankAccount {

	private int balance;
	private int previousTransaction;
	String customerName;
	String customerId;

	// constructor
	BankAccount(String cname, String cid) {
		this.customerName = cname;
		this.customerId = cid;
	}

	void checkBalance() {
		System.out.println("Balance is:" + balance);
	}

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
		if (amount > balance) {
			System.out.println("Not enough balance to widthdraw!");
		}
	}

	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No Transaction Occured");
		}
	}

	void showMenu() {
		Scanner scanner = new Scanner(System.in);

		int option;

		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerId);

		while (true) {
			System.out.println("1 : Check Your Balance");
			System.out.println("2 : Deposit");
			System.out.println("3 : Withdraw");
			System.out.println("4 : Previous Transaction");
			System.out.println("5 : Exit The System");

			System.out.println("Enter your choice:");
			option = scanner.nextInt();

			switch (option) {
				case 1 :
					checkBalance();
					break;

				case 2 :
					int deposit_amt;
					System.out.println("Enter deposit amount:");
					deposit_amt = scanner.nextInt();
					deposit(deposit_amt);
					break;

				case 3 :
					int withdraw_amt;
					System.out.println("Enter deposit amount:");
					withdraw_amt = scanner.nextInt();
					withdraw(withdraw_amt);
					break;

				case 4 :
					getPreviousTransaction();
					break;

				case 5 :
					System.out.println("Thank you!!");
					scanner.close();
					System.exit(0);
					break;
				default :
					System.out.println("Please choose correct option!");
					break;
			}
		}

	}

}
