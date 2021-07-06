import java.util.InputMismatchException;
class OneLeg extends Flight 
{
	int timeZoneDifference;
	int airborne;
	OneLeg()
	{
		while(true)
		{
			try {
				String flightNo;
				System.out.printf("Enter the Flight No: ");
				flightNo = myScanner.nextLine();
				
				if(!(isNumeric(flightNo)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int flightno = Integer.parseInt(flightNo);
					setflightNo(flightno);
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Flight no can be a numeric value!");
			}
		}
		
		System.out.printf("Enter the Departure Time;\n");
		departureTime = new DateTime();
		
		System.out.printf("Enter the Arrival Time;\n");
		arrivalTime = new DateTime();
		
		System.out.printf("Enter the Origin City: ");
		setoriginCity(myScanner.nextLine());
		
		System.out.printf("Enter the Destination City: ");
		destinationCity=myScanner.nextLine();
		
		while(true)
		{
			try {
				String maxLoadOfPlane;
				System.out.printf("Enter the max load: ");
				maxLoadOfPlane = myScanner.nextLine();
				
				if(!(isNumeric(maxLoadOfPlane)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int maxloadofplane = Integer.parseInt(maxLoadOfPlane);
					setmaxLoadOfPlane(maxloadofplane);
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Max load of plane can be a numeric value!");
			}
		}
		
		while(true)
		{
			try {
				String timeZoneDifference;
				System.out.printf("Enter the Time Zone Difference: ");
				timeZoneDifference = myScanner.nextLine();
				
				if(!(isNumeric(timeZoneDifference)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int timezonedifference = Integer.parseInt(timeZoneDifference);
					this.timeZoneDifference=timezonedifference;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Time zone difference can be a numeric value!");
			}
		}
		
		while(true)
		{
			try {
				String flightDistance;
				System.out.printf("Enter the flight distance: ");
				flightDistance = myScanner.nextLine();
				
				if(!(isNumeric(flightDistance)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int flightdistance = Integer.parseInt(flightDistance);
					this.flightDistance=flightdistance;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Flight distance can be a numeric value!");
			}
		}
		
		while(true)
		{
			try {
				String distanceRate;
				System.out.printf("Enter the distance rate: ");
				distanceRate = myScanner.nextLine();
				
				if(!(isNumeric(distanceRate)))
				{
					throw new InputMismatchException();
				}
				else
				{
					double distancerate = Double.parseDouble(distanceRate);
					this.distanceRate=distancerate;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Distance rate can be a numeric value!");
			}
		}
		
		while(true)
		{
			try {
				String flightPrice;
				System.out.printf("Enter the flight price: ");
				flightPrice = myScanner.nextLine();
				
				if(!(isNumeric(flightPrice)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int flightprice = Integer.parseInt(flightPrice);
					this.flightPrice=flightprice;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Flight price can be a numeric value!");
			}
		}
	}
	
	public void displayFlightInformation(){
		System.out.printf("Flight(no:%d) from %s to %s departs at ",getflightNo(),getoriginCity(),destinationCity);
		departureTime.displaydateInfo();
		System.out.printf(" and lands at ");
		arrivalTime.displaydateInfo();
		System.out.printf("");	
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
	
	public void calculateDuration() {
		airborne = (arrivalTime.hour - departureTime.hour) + timeZoneDifference;
		System.out.printf(" with duration of %d hour(s)", airborne);
	}
	
	public double computeExpense(){
		double expense = (double)flightPrice - (double)flightDistance*distanceRate;
		return expense;
	}

	@Override
	public int compareTo(Flight o) {
		return 0;
	}
}
