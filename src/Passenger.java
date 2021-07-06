import java.util.InputMismatchException;
import java.lang.Exception;
abstract class Passenger extends Person
{
	int miles;
	double milesRate;
	int memberYears;
		
	public Passenger()
	{	
		System.out.println("Enter your Passenger Information;");
			
		System.out.printf("Your name: ");
		name=myScanner.nextLine();
			
		System.out.printf("Your surname: ");
		surname=myScanner.nextLine();
		
		while(true)
		{
			try {
				String id;
				System.out.printf("Your ID: ");
				id = myScanner.nextLine();
				
				if(!(authenticateID(id)))
				{
					throw new IDMismatchException("ID is not valid!");
				}
				else
				{
					this.ID=id;
					break;
				}
				
			}catch(IDMismatchException e) {
				System.out.println("ID is not valid!");
			}
		}
		
		System.out.printf("Your password: ");
		password=myScanner.nextLine();
			
		while(true)
		{
			try {
				String miles;
				System.out.printf("Enter the miles: ");
				miles = myScanner.nextLine();
				
				if(!(isNumeric(miles)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int Miles = Integer.parseInt(miles);
					this.miles=Miles;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Miles can be a numeric value!");
			}
		}
		
		while(true)
		{
			try {
				String memberYears;
				System.out.printf("Member year(s): ");
				memberYears = myScanner.nextLine();
				
				if(!(isNumeric(memberYears)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int memberyears = Integer.parseInt(memberYears);
					this.memberYears=memberyears;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Member year(s) can be a numeric value!");
			}
		}
			
		while(true)
		{
			try {
				String milesRate;
				System.out.printf("Mile rate: ");
				milesRate = myScanner.nextLine();
				
				if(!(isNumeric(milesRate)))
				{
					throw new InputMismatchException();
				}
				else
				{
					double milesrate = Double.parseDouble(milesRate);
					this.milesRate=milesrate;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Mile rate can be a numeric value!");
			}
		}
	}
	public boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) 
	        	return false;
	    }
	    return true;
	}
	public boolean authenticateID(String str)
	{
		if(str.length() != 11)
			return false;
		else if(Integer.parseInt(String.valueOf(str.charAt(0))) <= 0)
			return false;
		else if(!(isNumeric(str)))
			return false;
		else if(!(tenthDigit(str)))
			return false;
		else if(!(eleventhDigit(str)))
			return false;
		else
			return true;
	}
	
	public boolean tenthDigit(String str)
	{
		int oddsum = Integer.parseInt(String.valueOf(str.charAt(0))) + 
				Integer.parseInt(String.valueOf(str.charAt(2))) +
				Integer.parseInt(String.valueOf(str.charAt(4))) +
				Integer.parseInt(String.valueOf(str.charAt(6))) +
				Integer.parseInt(String.valueOf(str.charAt(8)));
		
		int evensum = Integer.parseInt(String.valueOf(str.charAt(1))) + 
				Integer.parseInt(String.valueOf(str.charAt(3))) +
				Integer.parseInt(String.valueOf(str.charAt(5))) +
				Integer.parseInt(String.valueOf(str.charAt(7)));
		
		int eq = ((7*oddsum) - evensum) % 10;
		if(eq != Integer.parseInt(String.valueOf(str.charAt(9))))
			return false;
		else
			return true;
	}
	public boolean eleventhDigit(String str)
	{
		int sum=0;
		for(int i=0;i<10;i++)
		{
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		int eq = sum % 10;
		if(eq != Integer.parseInt(String.valueOf(str.charAt(10))))
			return false;
		else
			return true;
	}
}