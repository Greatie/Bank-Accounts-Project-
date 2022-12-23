//Design a class Date that has three integers for year, month and day. 
//provide a accessors and mutators for each
//default constructor that sets the date to 01/01/2000
//a constructor that accepts all three values
//a mutator to set all three values in month, day, year order.
//a method that accepts a date in a String form (two forms possible yyyy-mm-dd 
//or mm/dd/yyyy. 
//use the method above to design a constructor that accepts a date as a string.
import java.util.Scanner;
public class Date {
	private int year, month, day;
	
	public Date() // default constructor
	{
		year =2000;
		month=01;
		day =01;
		
	}
	//copy constructor
	public Date(Date d){
		this.setDate(d.toString());
	}
	
	public Date (int x, int y, int z)
	{
		
		year =x;
		month= y;
		day =z;
		
	}
	public Date(String st)
	{
		setDate(st);
	}
	public void setDate (String st)
	{
		if (st.contains("-"))	
		{
			String[] arr = st.split("-");
			if (arr.length != 3)
			{
				System.out.println("Invalid Date format");
			return;
			}
			
			year = Integer.parseInt(arr[0]);
			month = Integer.parseInt(arr[1]);
			day = Integer.parseInt(arr[2]);	
		}
		else  if (st.contains("/"))
		{ 
			String[] arr = st.split("/");
			if (arr.length != 3)
			{
				System.out.println("Invalid Date format");
			return;
			}
			
			month = Integer.parseInt(arr[0]);
			day = Integer.parseInt(arr[1]);
			year = Integer.parseInt(arr[2]);	
		
         }
		else 
		System.out.println("Invalid Date format");
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
		
	public String toString()
	{
		return ( "" + year + "-" +month+ "-" +day);
	}
	public void read(Scanner sc) {
		System.out.print("Enter the date in the form: mm/dd/yyyy or yyyy-mm-dd:");
		setDate(sc.nextLine());
	}
}
