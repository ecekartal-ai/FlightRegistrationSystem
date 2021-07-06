import java.util.Locale;
import java.util.Scanner;

public class Ticket {
	private int ticketNo;
	Flight flight;
	Person passengerInfo;
	String seat;
	String Class;
	Scanner myScanner = new Scanner(System.in).useLocale(Locale.US);
	
	public Ticket()
	{
		System.out.printf("Enter your seat number: ");
		seat=myScanner.nextLine();
		
		System.out.printf("Enter your class: ");
		Class=myScanner.nextLine();
	}
	
	public int getticketNo(){
		return ticketNo;
	}

	public void setticketNo(int ticketNo){
		this.ticketNo = ticketNo;
	}
}
