import java.util.InputMismatchException;
class Admin extends Staff
{
	int bonusSalary;
		
	public Admin()
	{
		while(true)
		{
			try {
				String bonusSalary;
				System.out.printf("Bonus Salary: ");
				bonusSalary = myScanner.nextLine();
				if(!(isNumeric(bonusSalary)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int bonussalary = Integer.parseInt(bonusSalary);
					this.bonusSalary=bonussalary;
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Bonus salary can be a numeric value!");
			}
		}
	}
	public double computeExpense(){
		double expense = (double)Salary + (double)bonusSalary;
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
