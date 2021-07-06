import java.util.InputMismatchException;
abstract class Staff extends Person
{
	int Salary;
			
	public Staff()
	{	
		System.out.println("Enter your Staff Information;");
			
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
				String Salary;
				System.out.printf("Salary: ");
				Salary = myScanner.nextLine();
				
				if(!(isNumeric(Salary)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int salary = Integer.parseInt(Salary);
					this.Salary=salary;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Salary can be a numeric value!");
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
