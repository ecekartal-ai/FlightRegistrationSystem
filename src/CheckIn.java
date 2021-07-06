import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CheckIn {
	Ticket ticket;
	int weightOfLuggage;
	DateTime checkInTime;
	boolean valid;
	Scanner myScanner = new Scanner(System.in).useLocale(Locale.US);
	
	public CheckIn() 
	{
		while(true)
		{
			try {
				String weightOfLuggage;
				System.out.printf("Weight of luggage: ");
				weightOfLuggage = myScanner.nextLine();
				if(!(isNumeric(weightOfLuggage)))
				{
					throw new InputMismatchException();
				}
				else
				{
					int weightofluggage = Integer.parseInt(weightOfLuggage);
					this.weightOfLuggage=weightofluggage;
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Weight of luggage can be a numeric value!");
			}
		}
		System.out.printf("Enter your check in time; \n");
		checkInTime = new DateTime();
		
		valid=false;
	}
	
	public void displaycheckinInfo(){
		System.out.printf("\nCheck-In of %s %s\n", Person.name , Person.surname);
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
