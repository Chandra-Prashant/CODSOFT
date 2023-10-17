import java.util.Scanner;
//class Representing the ATM
class ATM{
    private UserBankAccount userbankAccount;
    public ATM(UserBankAccount userbankAccount){
        this.userbankAccount=userbankAccount;
    }
}
//class representing the bank account of the user
class UserBankAccount{
    private double balance;
	//constructor
    public UserBankAccount(double previousbalance){
        this.balance=previousbalance;
    }
	//deposit method
    public double deposit(double amount){
		System.out.println("Your "+amount+" rupees has been deposited successfully!!!");
		System.out.println();
		return balance=balance+amount;
    }
	//withdraw method
    public double withdraw(double amount){
		System.out.println("Your "+amount+" rupees has been withdrawn successfully!!!");
		System.out.println();
		return balance=balance-amount;
	}
	//checkBalance method
    double checkBalance(){
        return this.balance;
    }
}
//Main class
public class ATMRUN{
	public static void main(String [] args){
		//initialising the balance in the account
		int previousbalance=10000;
		//initialising the pin of the account
		int ATMPIN=1234;
		//creating object of the UserBankAccount class
		UserBankAccount user=new UserBankAccount(previousbalance);
		Scanner scan=new Scanner(System.in);
		System.out.println("Hey User,Welcome to the ATM!!!");
		System.out.println("Please make sure that its you...");
		System.out.print("Enter the four digit PIN of your Account: ");
		int PIN=scan.nextInt();
		if (PIN==ATMPIN){
			System.out.println();
			System.out.println("Dear user 1234 you are in!!!");
			System.out.println();
		}
		else{
			System.out.println("Sorry you can't enter as the PIN you entered is wrong");
			System.exit(0);
		}
		while(true){
			//Menu list
			System.out.println("Enter 1 for Checking the account balance");
			System.out.println("Enter 2 for Depositing money to the account");
			System.out.println("Enter 3 for Withdrawing money from the account");
			System.out.println("Enter 4 to Exit");
			System.out.print("You chose:");
			int choice=scan.nextInt();
			switch(choice){
				case 1:
					double balance=user.checkBalance();
					System.out.println();
					System.out.println("Currently your account has Rupee "+balance);
					System.out.println();
					break;
				case 2:
					System.out.println();
					System.out.print("Enter the amount to be deposited:");
					double amount=scan.nextInt();
					user.deposit(amount);
					break;
				case 3:
					System.out.println();
					System.out.print("Enter the amount to be withdrawn:");
					amount=scan.nextInt();
					double check=user.checkBalance();
					if(amount>check){
						System.out.println("Sorry this can't be done because of insufficient balance.");
					}
					else{
						user.withdraw(amount);
					}
					break;
				case 4:
					System.out.println("Thank you for using the ATM!!!");
					System.exit(0);
				default:
					System.out.println();
					System.out.println("---Wrong Choice---");
					System.out.println("Kindly select valid option");
					System.out.println();
			}
		}
	}
}