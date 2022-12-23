//design a class Person that has the following properties:
//DoB date of birth of the person, use the class Date
// first name, last name, address, SSN. 
//getters and setters, constructors of your choice, just make your class flexible.
import java.util.Scanner;
public class Person extends Date{
	private String fName, lName, address;
	private int ssn;
	
	Person(){
		super();
		fName = lName = address = "";
		ssn = 0;
	}
	//Copy constructor for Person 
	public Person(Person p){
		fName = p.fName;
		lName = p.lName;
		address = p.address;
		ssn = p.ssn;
		super.setDate(p.getDoB().toString());
	}
	public Person(String fN, String lN, String add, int s, Date d){
		fName = fN;
		lName = lN;
		address = add;
		ssn = s;
		super.setDate(d.toString());
	}
	public Person(String fN, String lN, String add, int s, String d){
	
		fName = fN;
		lName = lN;
		address = add;
		ssn = s;
		super.setDate(d);
	}

	public Date getDoB() {
		//remember Person is a Date, if assigned to a Date object only the 
		//inherited Date object will be assigned which is the DoB
		Date d = (Date) this;
		return d;
	}

	public void setDoB(Date doB) {
		super.setDate(doB.toString());
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	} 
	public String toString(){
		String st = "";
		st = st + "First name:" +fName +"\nLast name: " +lName +"\nSSN:"+ssn +"\nDate of Birth:" 
				+super.toString() +"\nAddress: " +address;  
		return st;
	}
	public void read(Scanner sc){
		System.out.print("First name:");
		fName = sc.nextLine();
		System.out.print("Last name:");
		lName = sc.nextLine();
		System.out.print("Address:");
		address = sc.nextLine();
		System.out.print("SSN:");
		ssn = Integer.parseInt(sc.nextLine());
		System.out.print("Date of birth: ");
		super.read(sc);
		
	}
}