import java.util.InputMismatchException;
class CheckInCounter extends Staff
{
	int overTimeHours;
	int overTimeRate;
		
	public CheckInCounter()
	{
		while(true)
		{
			try {
				String overTimeHours;
				System.out.printf("Over Time Hours: ");
				overTimeHours = myScanner.nextLine();
				if(!(isNumeric(overTimeHours)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int overtimehours = Integer.parseInt(overTimeHours);
					this.overTimeHours=overtimehours;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Over time hours can be a numeric value!");
			}
		}
		while(true)
		{
			try {
				String overTimeRate;
				System.out.printf("Over Time Rate: ");
				overTimeRate = myScanner.nextLine();
				
				if(!(isNumeric(overTimeRate)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int overtimerate = Integer.parseInt(overTimeRate);
					this.overTimeRate=overtimerate;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Over time rate can be a numeric value!");
			}
		}
	}
	public double computeExpense(){
		double expense = (double)Salary + (double)overTimeHours*(double)overTimeRate;
		return expense;
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
}