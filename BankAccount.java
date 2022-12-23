//design a class BankAccount that has the following properties:
//an array of maximum 5 owners (Persons)
//the number of holders (At the beginning there is only one holder, subsequent 
//holders are added via a method addHolder())
//AccountNumber (generate account numbers sequentially, use a static variable)
//balance, interest rate, 
//Date the account was opened, date interest was payed(initially same as open date).
//Methods: Deposit(), Withdraw(), payInterest(), toString(), addholder(), removeOwner()

import java.util.*;
public class BankAccount {
	
	private Vector<Person> owner = new Vector<Person>(5); // lesson learned: don't add static
	private double balance;
	private static int statAccNum = 0;
	private int accNum;
	private Date accOpened;
	private Date datePaid = new Date();
	private double interestRate = 5.5;
	private int counter = 0;
	
	// default constr
	public BankAccount()
	{
		accNum = ++statAccNum; 
		balance = 0.0;
	}
	
	//copy constrs
	public BankAccount(Person a, double b, Date c)
	{
		this.owner.addElement(new Person(a));
		balance = b;
		accNum++;
		accOpened = new Date(c);
	}
	
	public BankAccount(Person a, double b)
	{
		this.owner.addElement(new Person(a));
		balance = b;
		accNum++;
	}
	
	public BankAccount(Person a)
	{
		this.owner.addElement(new Person(a));
		balance = 0.0;
		accNum++;
	}
	
	// this constructor works as planned! next step:
	// use getters and setters to use balance and accNum as followed. (setBalance, getBalance, etc).
	
	public void setBalance(double b)
	{
		balance = b;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setAccOpened(Date c)
	{
		accOpened = new Date(c);
	}
	
	public void setAccOpenedS(String c)
	{
		accOpened = new Date(c);
	}
	
	public Date getAccOpened()
	{
		return accOpened;
	}
	
	public void addHolder(Person a)
	{
		accNum++;
		this.owner.addElement(new Person(a));
	}
	
	public int getAccountNum()
	{
		return accNum;
	}
	
	public void removeHolder(Person a)
	{
		// don't forget to check if less than 0 (if-statement)
		accNum--;
		owner.removeElement(a);
	}
	
	public void Deposit(double amount)
	{
		double deposit = balance + amount;
		if(amount < 0)
		{
			System.out.println("Dude why are you trying to deposit a negative number?");
			setBalance(deposit);
		}
		else
			setBalance(deposit);
	}
	
	public void Withdrawl(double amount)
	{
		double withdrawl = balance - amount;
		if(withdrawl  < 0)
		{
			System.out.println("YOU'RE GONNA GO IN DEBT SO WE CAN'T DO THIS");
			//setBalance(withdrawl);	
		}
		else
			setBalance(withdrawl);
	}
	
	// balance, interest rate, 
	//Date the account was opened, date interest was payed(initially same as open date).
	public void payInterest()
	{
		counter++; // count the month each time the method is run sequentially
		setBalance((getBalance()) + (interestRate) * 12);
		
		datePaid.setDay(accOpened.getDay()); 
		datePaid.setYear(accOpened.getYear());
		datePaid.setMonth(accOpened.getMonth() + counter);	

		
		if(datePaid.getMonth() > 12) // if month is greater than 12, add 1 year
		{
			datePaid.setMonth(datePaid.getMonth() % 12); // returns the remainder of 12
			datePaid.setYear(datePaid.getYear() + 1);
		}
		
		System.out.println("Monthly interest paid! Date paid: " + datePaid.toString());
	}
	
	// findAccount(): finds a bank account at a specific element (accNum = element position).
	public String findAccount(int accNum)
	{
		return owner.elementAt(accNum).toString();	
	}
	
	public boolean findAccountNum(int x)
	{
		for(int i = 0; i < owner.size(); i++)
		{
			if(accNum == x)
			{
				// do things
				return true;
			}
		}
		return false;
	}
	
	// testing
	public int findAccountIndex(int x)
	{
		for(int i = 0; i < owner.size(); i++)
		{
			if(owner.elementAt(i).getSsn() == x)
			{
				// return index
				return i;
			}
		}
		return -1; // did not find anything
	}

	// printHoldersInfo(): prints all the Holders (excluding the primary holder).
	public String printHoldersInfo()
	{
		String st = "";
		for(int i = 1; i < owner.size(); i++)
		{
			st += owner.elementAt(i).toString() + "\n";
		}
		return st;
	}
	
	public void setFirstHolder()
	{
		owner.add(owner.firstElement());
	}
	
	public void read(Scanner sc) 
	{
		boolean choice = false;
		
		if(choice == false) // first time setup
		{
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = (c.get(Calendar.MONTH) + 1); // month starts at 0
			int day = c.get(Calendar.DATE);
			
			//String f = sc.nextLine();
			Date input = new Date();
			input.setYear(year);
			input.setMonth(month);
			input.setDay(day);
			
			String temp = month + "/" + day + "/" + year; // for accOpened
			String time = "" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE); // 24-hour clock
			
			System.out.println("Hello and welcome. Today's date is: " + input.toString() + "." + " The time now is: " + time);
			//input.setDate(f);
			this.setAccOpenedS(temp);
		}

		System.out.println("Enter your credentials: ");
		Person info = new Person();
		info.read(sc);
		owner.add(info);
		//this.addHolder(info);
		
		System.out.println("Enter the starting balance to open your account: ");
		this.setBalance(sc.nextDouble());	
		//accNum++;
		
		System.out.println("Account succesfully made.");
		System.out.print("Do you wish to add more holders? [y/n]: ");
		sc.nextLine();
		String check = sc.nextLine();
		
		while(check.equalsIgnoreCase("y")) // if the user types yes then run loop, 2nd time setup
		{
			choice = true; // second time setup, ignore date
			if(owner.size() <= 5) // just in case the size exceeds its normal size
			{
				System.out.println("Enter your credentials: ");
				Person newinfo = new Person();
				newinfo.read(sc);
				owner.add(newinfo);
				
				System.out.println("Holder successfully made.");
				System.out.print("Countinue making holders? [y/n]: ");
				check = sc.nextLine();
			}
			else
			{
				System.out.println("ERROR: Cannot add more than 5 holders!");
				break;
			}
		}
	}
	
	public String toString()
	{
		String st = "";
		st = "\n\nPrimary holder: " + owner.firstElement().toString() + "\n" + "\nHolders: " + this.printHoldersInfo() + " \nBalance: " + balance + " \nAccount #: " + accNum + "\nDate opened: " + accOpened + "\n";
		return st;
	}
}
