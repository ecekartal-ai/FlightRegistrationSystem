import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DateTime {
	int day;
	int month;
	int year;
	int hour;
	int minute;
	Scanner myScanner = new Scanner(System.in).useLocale(Locale.US);
	
	public DateTime()
	{	
		while(true)
		{
			try {
				String year;
				System.out.printf("Year: ");
				year = myScanner.nextLine();
				
				if(!(isNumeric(year)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int Year = Integer.parseInt(year);
					this.year=Year;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Year can be a numeric value!");
			}
		}
		while(true)
		{
			try {
				String month;
				System.out.printf("Month: ");
				month = myScanner.nextLine();
				
				if(!(isNumeric(month)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int Month = Integer.parseInt(month);
					this.month=Month;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Month can be a numeric value!");
			}
		}
		while(true)
		{
			try {
				String day;
				System.out.printf("Day: ");
				day = myScanner.nextLine();
				
				if(!(isNumeric(day)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int Day = Integer.parseInt(day);
					this.day=Day;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Day can be a numeric value!");
			}
		}
		while(true)
		{
			try {
				String hour;
				System.out.printf("Hour: ");
				hour = myScanner.nextLine();
				
				if(!(isNumeric(hour)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int Hour = Integer.parseInt(hour);
					this.hour=Hour;
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Hour can be a numeric value!");
			}
		}
		while(true)
		{
			try {
				String minute;
				System.out.printf("Minute: ");
				minute = myScanner.nextLine();
				
				if(!(isNumeric(minute)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int Minute = Integer.parseInt(minute);
					this.minute=Minute;
					break;
				}
				
			}catch(NumberFormatException e) {
				System.out.println("Minute can be a numeric value!");
			}
		}
	}
	
	public void displaydateInfo(){
		String strYear = year+"";
		String strDay = day+"";
		String strMonth = month+"";
		String strHour = hour+"";
		String strMinute = minute+"";
		if(day<10) {
			strDay = "0"+day;
		}
		if(month<10) {
			strMonth = "0" + month;
		}
		if(hour<10) {
			strHour = "0"+hour;
		}
		if(minute<10) {
			strMinute = "0"+minute;
		}
		System.out.printf("%s/%s/%s %s:%s:00", strDay, strMonth, strYear, strHour, strMinute);
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
