import java.util.InputMismatchException;
class ThreeLeg extends TwoLeg
{
	int thirdTimeZoneDifference;
	DateTime departureTime3,arrivalTime3;
	String destinationCity3;
	ThreeLeg()
	{
		System.out.println("");
		System.out.printf("Enter the third Departure Time;\n");
		departureTime3 = new DateTime();
			
		System.out.printf("Enter the third Arrival Time;\n");
		arrivalTime3 = new DateTime();
			
		System.out.printf("Enter the third Destination City: ");
		destinationCity3 = myScanner.nextLine();
		
		while(true)
		{
			try {
				String thirdTimeZoneDifference;
				System.out.printf("Enter the third Time Zone Difference: ");
				thirdTimeZoneDifference = myScanner.nextLine();
				
				if(!(isNumeric(thirdTimeZoneDifference)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int thirdtimezonedifference = Integer.parseInt(thirdTimeZoneDifference);
					this.thirdTimeZoneDifference=thirdtimezonedifference;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Third time zone difference can be a numeric value!");
			}
		}
	}
	
	public void displayFlightInformation(){
		System.out.printf("Flight(no:%d) from %s to %s departs at ",getflightNo(),getoriginCity(),destinationCity3);
		departureTime.displaydateInfo();
		System.out.printf(" and lands at ");
		arrivalTime3.displaydateInfo();
		System.out.printf("");
	}
	
	public void calculateDuration() {
		airborne = (arrivalTime.hour - departureTime.hour) + timeZoneDifference + (arrivalTime2.hour - departureTime2.hour) + secondTimeZoneDifference 
				+ (arrivalTime3.hour - departureTime3.hour) + thirdTimeZoneDifference;
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