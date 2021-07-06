import java.util.InputMismatchException;
class Elite extends Passenger
{
	double yearRate;
					
	public Elite()
	{
		while(true)
		{
			try {
				String yearRate;
				System.out.printf("Year Rate: ");
				yearRate = myScanner.nextLine();
				
				if(!(isNumeric(yearRate)))
				{
					throw new InputMismatchException();
				}
				else
				{
					double yearrate = Double.parseDouble(yearRate);
					this.yearRate=yearrate;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Year rate can be a numeric value!");
			}
		}
	}
	public double computeExpense(){
		double expense = (double)miles*milesRate + (double)memberYears*yearRate;
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
