import java.util.InputMismatchException;
class ElitePlus extends Passenger
{
	double yearRate;
	int yearlyFixedMiles;
					
	public ElitePlus()
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
		while(true)
		{
			try {
				String yearlyFixedMiles;
				System.out.printf("Yearly Fixed Miles: ");
				yearlyFixedMiles = myScanner.nextLine();
				
				if(!(isNumeric(yearlyFixedMiles)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int yearlyfixedmiles = Integer.parseInt(yearlyFixedMiles);
					this.yearlyFixedMiles=yearlyfixedmiles;
					break;
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Yearly fixed miles can be a numeric value!");
			}
		}
	}
	public double computeExpense(){
		double expense = (double)miles*milesRate + (double)memberYears*yearRate + (double)yearlyFixedMiles*yearRate;
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
