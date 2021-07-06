import java.util.InputMismatchException;
class TwoLeg extends OneLeg
{
	int secondTimeZoneDifference;
	DateTime departureTime2,arrivalTime2;
	String destinationCity2;
	TwoLeg()
	{
		System.out.println("");
		System.out.printf("Enter the second Departure Time;\n");
		departureTime2 = new DateTime();
			
		System.out.printf("Enter the second Arrival Time;\n");
		arrivalTime2 = new DateTime();
			
		System.out.printf("Enter the second Destination City: ");
		destinationCity2 = myScanner.nextLine();
		
		while(true)
		{
			try {
				String secondTimeZoneDifference;
				System.out.printf("Enter the second Time Zone Difference: ");
				secondTimeZoneDifference = myScanner.nextLine();
				
				if(!(isNumeric(secondTimeZoneDifference)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int secondtimezonedifference = Integer.parseInt(secondTimeZoneDifference);
					this.secondTimeZoneDifference=secondtimezonedifference;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Second time zone difference can be a numeric value!");
			}
		}
	}
	
	public void displayFlightInformation(){
		System.out.printf("Flight(no:%d) from %s to %s departs at ",getflightNo(),getoriginCity(),destinationCity2);
		departureTime.displaydateInfo();
		System.out.printf(" and lands at ");
		arrivalTime2.displaydateInfo();
		System.out.printf("");	
	}
	
	public void calculateDuration() {
		airborne = (arrivalTime.hour - departureTime.hour) + timeZoneDifference + (arrivalTime2.hour - departureTime2.hour) + secondTimeZoneDifference;
		System.out.printf(" with duration of %d hour(s)", airborne);
	}
	
	public double computeExpense(){
		double expense = (double)flightPrice - (double)flightDistance*distanceRate;
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
