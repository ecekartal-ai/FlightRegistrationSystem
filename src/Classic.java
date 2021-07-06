class Classic extends Passenger
{
	public Classic()
	{
		
	}
	public double computeExpense(){
		double expense = (double)miles*milesRate;
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
