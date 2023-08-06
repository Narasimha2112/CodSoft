
import java.util.Scanner;

class ATM
{
    String name;
	String userName;
	String password;
	String accountNo;
	float balance = 0;
	int transactions = 0;
	String transactionHistory = "";


    //register of the user
    public void register() 
    {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name - ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username - ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password - ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number - ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration completed..kindly login");
	}


    //login of the user
    public boolean login() 
    {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print("\nEnter Your Username - ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isLogin ) {
					System.out.print("\nEnter Your Password - ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("\nLogin successful!!");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}

	//WITHDRAW
    public void withdraw() 
    {
		System.out.print("\nEnter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
	}

	//deposit
    public void deposit() 
    {	
		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}

	//checkBalance
    public void checkBalance() 
    {
		System.out.println("\n" + balance + " Rs");
	}

    public void transHistory() 
    {
		if ( transactions == 0 ) 
        {
			System.out.println("\nEmpty");
		}
		else 
        {
			System.out.println("\n" + transactionHistory);
		}
	}
}

public class AtmInterface 
{
	public static int takeIntegerInput(int limit) 
	{
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}

	public static void main(String[] args) 
	{
		System.out.println("\n**********WELCOME TO ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) 
		{
			ATM A = new ATM();
			A.register();
			while(true) 
			{
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) 
				{
					if (A.login()) 
					{
						System.out.println("\n\n**********WELCOME BACK " + A.name + " **********\n");
						boolean isFinished = false;
						while (!isFinished) 
						{
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Check Balance \n4.Transaction History \n5.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(5);
							switch(c) 
							{
								case 1:
								A.withdraw();
								break;
								case 2:
								A.deposit();
								break;
								case 3:
								A.checkBalance();
								break;
								case 4:
								A.transHistory();
								break;
								case 5:
								isFinished = true;
								break;
							}
						}
					}
				}
				else 
				{
					System.exit(0);
				}
			}
		}
		else 
		{
			System.exit(0);
		}
	}

}