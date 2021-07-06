import java.util.Locale;
import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;

abstract class Flight implements Expense, Comparable<Flight>{
	private int flightNo;
	public DateTime departureTime;
	public DateTime arrivalTime;
	private String originCity;
	public String destinationCity;
	private int maxLoadOfPlane;
	int flightDistance;
	double distanceRate;
	int flightPrice;
	Scanner myScanner = new Scanner(System.in).useLocale(Locale.US);
	
	public void displayFlightInformation(){
		System.out.printf("Flight(no:%d) from %s to %s departs at ",getflightNo(),getoriginCity(),destinationCity);
		departureTime.displaydateInfo();
		System.out.printf(" and lands at ");
		arrivalTime.displaydateInfo();
		System.out.printf("");	
	}
	
	public void calculateDuration() {
		System.out.printf("%d", 0);
	}
	
	public int getflightNo(){
		return flightNo;
	}
	
	public void setflightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getoriginCity(){
		return originCity;
	}
	
	public void setoriginCity(String originCity) {
		this.originCity = originCity;
	}
	
	public int getmaxLoadOfPlane(){
		return maxLoadOfPlane;
	}
	
	public void setmaxLoadOfPlane(int maxLoadOfPlane) {
		this.maxLoadOfPlane = maxLoadOfPlane;
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
	
	public static Comparator<Flight> departureComparator = new Comparator<Flight>(){
		@Override
		public int compare(Flight o1, Flight o2) {
			int yearCompare = o1.departureTime.year - o2.departureTime.year;
			if(yearCompare != 0)
			{
				return yearCompare;
			}
			
			int monthCompare = o1.departureTime.month - o2.departureTime.month;
			if(monthCompare != 0)
			{
				return monthCompare;
			}
			
			int dayCompare = o1.departureTime.day - o2.departureTime.day;
			if(dayCompare != 0)
			{
				return dayCompare;
			}
			
			int hourCompare = o1.departureTime.hour - o2.departureTime.hour;
			if(hourCompare != 0)
			{
				return hourCompare;
			}
			
			int minuteCompare = o1.departureTime.minute - o2.departureTime.minute;
			return minuteCompare;
		}
	};
}
