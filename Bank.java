//Design a class Bank that has a vector of bankAccounts and a set of methods to 
//manipulate those accounts.
//createAccount(), removeAccount(), showAccount()
//list all accounts
//find an account, modifyAccount() (can modify everything except the account number)
import java.util.*;
public class Bank {
	
	private Vector<BankAccount> accounts;
	//private static int counter = 0;
	
	public Bank()
	{
		accounts = new Vector<BankAccount>();
	}

	// createAccount(): Creates a new Bank Account, then adds it at the end of the Vector.
	public void createAccount()
	{
		Scanner input = new Scanner(System.in);
		BankAccount AB = new BankAccount();
		AB.read(input);
		//this.newAccount();
		accounts.addElement(AB);
	}
	
	public String printFirstAccount() // prints 1st account
	{
		return accounts.firstElement().toString();
	}
	
	public String printLastAccount() // prints last account
	{
		return accounts.lastElement().toString();
	}
	
	// removeAccount(): Removes accounts at position at 1 - i (i being the position of the Vector).
	public void removeAccount()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the account number to remove from the system: ");
		int temp = sc.nextInt() - 1; // Vectors starts at 0, accNums start at 1, so 1 - 1 = 0.
		accounts.removeElementAt(temp);
		System.out.println("Account number " + (temp + 1) + " removed.");
	}
	
	// modifyAccount(): Gives the user 4 options to do once the Account Number has been successfully inputed:
	// Deposit, Withdraw, pay monthly interest and add holders.
	public void modifyAccount()
	{
		// do things with accNum and make loop to find it and modify account
		System.out.println("Hello and welcome to the modification menu!");	
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your Account Number: ");
		int x = sc.nextInt(); 
		sc.nextLine();
		
		for(int i = 0; i < accounts.size(); i++) // go through all accounts
		{
			if(accounts.elementAt(i).getAccountNum() == x) // if the element (at position i) is the same as the accNum that the user input, then give the menu
			{
				System.out.println("Enter what option you'd like to do: ");
				System.out.println("1. Make a deposit to your account");
				System.out.println("2. Make a withdrawl to your account");
				System.out.println("3. Pay your monthly interest");
				System.out.println("4. Add holders"); 
				//System.out.println("5. Remove holder");// TODO
				System.out.print("Please input what to do: ");
				x = sc.nextInt();
				sc.nextLine();
				
				switch(x)
				{
				case 1:
					System.out.print("How much would you like to deposit?: ");
					double y = sc.nextDouble();
					//int option = sc.nextInt() - 1;
					if(y < 0)
						System.out.println("Cannot deposit negative amounts.");
					else
					{
						accounts.elementAt(i).Deposit(y);
						System.out.println("Successfully deposited $" + y);
					}
					break;
				case 2:
					System.out.print("How much would you like to withdrawl?: ");
					y = sc.nextDouble();
		
					if(y < 0)
						System.out.println("Cannot withdraw negative amounts.");
					else
					{
						if(accounts.elementAt(i).getBalance() < 0)
						{
							System.out.println(""); // do nothing, msg is already handled.
						}
						accounts.elementAt(i).Withdrawl(y); // else withdraw
						System.out.println("Succesfully withdrew $" + y);
					}
					break;
				case 3:
					accounts.elementAt(i).payInterest();
					System.out.println("Account interest paid.");
					break;
				case 4:
					Person addinfo = new Person();
					addinfo.read(sc);
					accounts.elementAt(i).addHolder(addinfo);
					break;
				}
				break;
			}
		}	 
	}
	
	// reminder: determineaccount() is the same as showaccount()
	public void determineAccount() // find the accounts by Account Number and grab info by that
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your Account Number: ");
		int x = sc.nextInt() - 1; 
		sc.nextLine();
		
		for(int i = 0; i < accounts.size(); i++) // go through ALL accounts
		{
			if(x < 0)
			{
				System.out.print("Negative integer detected. Please input a postive number next time\n");
				//this.determineAccount();
				break;
			}
			else if(x >= accounts.size())
			{
				System.out.println("Account not found. Please try again.\n");
				//this.determineAccount();
				break;
			}
			else
				System.out.println("Account found: " + accounts.elementAt(i).findAccount(x)); 
			// account starts at 1, must start at 0!
		}	
	}
	
	// find(): Searches for all accounts, then stops when a specific account number
	// is found. It then prints out the specific element at which it is found.
	public void find()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your Account Number: ");
		int x = sc.nextInt(); 
		sc.nextLine();
		
		for(int i = 0; i < accounts.size(); i++)
		{
			if(accounts.elementAt(i).getAccountNum() == x)
			{
				System.out.println(accounts.elementAt(i));
			} 
		}
	}
	
	// menu(): Displays all possible options that the user can do. User options include:
	//Deposit, Withdrawl, add new accounts and exit.
	public void menu()
	{
		boolean val = true;
		while(val) // infinite loop so that the user can have unlimited options (until they close)
		{
			System.out.println("Hello and Welcome to our Bank! Enter what option you'd like to do: ");
			System.out.println("1. Create a new Bank Account");
			System.out.println("2. Find an account");
			System.out.println("3. Remove an Account");
			System.out.println("4. Print all existing Bank Accounts");
			System.out.println("5. Modify your account (deposit, withdrawl, pay interest)");
			System.out.println("6. Exit");
			
			System.out.print("Please input your option: ");
			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
			sc.nextLine();
			//sc.close();
			
			switch(x)
			{
			case 1:
				createAccount();
				break;
			case 2: // remember to code if statement using isEmpty()
				if(accounts.isEmpty())
					System.out.println("\nNothing to find! (no Bank Accounts created)\n");
				else
					find();
				break;
			case 3: // remember to code if statement using isEmpty()
				if(accounts.isEmpty())
					System.out.println("\nNothing to remove! No Bank Accounts found.\n");
				else
					removeAccount();
				break;
			case 4:
				if(accounts.isEmpty())
					System.out.println("\nNothing to print out (Bank Account is empty).\n");
				else
					System.out.println(accounts.toString());
				break;
			case 5:
				if(accounts.isEmpty())
					System.out.println("\nNothing to modify (no Bank Accounts)\n");
				else
					modifyAccount();
				break;
			case 6: // gtfo of the loop
				if(accounts.isEmpty())
				{
					val = false;
					System.out.println("Exiting out...");
					break;
				}
				System.out.println("Exiting out...");
				val = false;
				break;
			default:
				System.out.print("\nInvalid input, please try again\n");				
			}
		}
	}
	
	public String toString()
	{
		String st = "";
		if(accounts.size() == 0)
			st = "Empty accounts (and the bank keeps getting poorer...)!";
		else
			st = "\n\nBank Accounts: " + accounts.toString();
		return st;
	}
}