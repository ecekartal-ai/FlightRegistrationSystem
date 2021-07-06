import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Collections;

enum MainMenu
{
    AddStaff("Add a staff."), 
    AddPassenger("Add a passenger."), 
    LoginStaff("Staff login."),
    LoginPassenger("Passenger login."), 
    ExitMain("Exit.");
    
    private String option;

    MainMenu(String option){
        this.option = option;}

    public String getMeaning(){
        return option;}
}
enum AdminMenu
{
    AddFlight("Add a new flight."), 
    ShowFlightInfoA("Show flight information."), 
    TakeOff("Calculate take-off load."),
    Expenses("Calculate expenses."), 
    SwitchUserAdmin("Switch users."),
    ExitAdmin("Exit.");
    
    private String option;

    AdminMenu(String option){
        this.option = option;}

    public String getMeaning(){
        return option;}
}
enum CheckInCounterMenu
{
    ShowFlightInfoC("Show flight information."), 
    ProcessCheckIn("Process a check-in."), 
    ValidCheckIn("Display valid check-ins."),
    SwitchUserCounter("Switch users."),
    ExitCounter("Exit.");
    
    private String option;

    CheckInCounterMenu(String option){
        this.option = option;}

    public String getMeaning(){
        return option;}
}
enum PassengerMenu
{
    ShowFlightInfoP("Show flight information."), 
    BuyTicket("Buy ticket."), 
    RequestCheckIn("Request a check-in."),
    SwitchUserPassenger("Switch users."),
    ExitPassenger("Exit.");
    
    private String option;

    PassengerMenu(String option){
        this.option = option;}

    public String getMeaning(){
        return option;}
}
enum StaffOptions
{
	AddAdmin("Add Admin."),
	AddCheckInCounter("Add Check In Counter.");
	
	private String option;
	
	StaffOptions(String option){
        this.option = option;}

    public String getMeaning(){
        return option;} 
}
enum PassengerOptions
{
	AddClassic("Add Classic Passenger."),
	AddElite("Add Elite Passenger."),
	AddElitePlus("Add Elite Plus Passenger.");
	
	private String option;
	
	PassengerOptions(String option){
        this.option = option;}

    public String getMeaning(){
        return option;} 
}
enum FlightOptions
{
    NonStop("Create non-stop flight."), 
    TwoLeg("Create a two-leg flight."), 
    ThreeLeg("Create a three-leg flight.");

    private String option;

    FlightOptions(String option){
        this.option = option;}

    public String getMeaning(){
        return option;}
}

public class Main {
	
	private static Scanner input = new Scanner(System.in).useLocale(Locale.US);
	static Scanner myScanner1= new Scanner(System.in).useLocale(Locale.US);

	public static void main(String[] args) {
		int staffIndex = 0;
		int passengerIndex = 0;
		int flightIndex = 0;
		int customerCount = 0;
		int chIndex = 0;
		
		ArrayList<Expense> expenseArray = new ArrayList<Expense>();
		ArrayList<Ticket> ticketArray = new ArrayList<Ticket>();
		ArrayList<CheckIn> checkInArray = new ArrayList<CheckIn>();
		
		MainMenu Mainmenu = MainMenu.AddStaff;
		
		while(Mainmenu != MainMenu.ExitMain)
			try
			{
				mainmenu();
				
				Mainmenu = MainMenu.values()[Integer.parseInt(input.nextLine().trim())-1];
				
				switch(Mainmenu)
				{
					case AddStaff:
						StaffOptions staffOptions = StaffOptions.AddAdmin;
						
						while (staffOptions != StaffOptions.AddCheckInCounter)
							try
							{
								staffoptions();
								
								staffOptions = StaffOptions.values()[Integer.parseInt(input.nextLine().trim()) - 1];
								
								switch (staffOptions)
								{
									case AddAdmin://admin
										
										expenseArray.add(new Admin());
										staffOptions = StaffOptions.AddCheckInCounter;
										break;
									case AddCheckInCounter://check in counter
										
										expenseArray.add(new CheckInCounter());
										staffOptions = StaffOptions.AddCheckInCounter;
										break;
									
									default:
					                    System.out.println("Selection out of range. Try again");
								}
								staffIndex++;
							}
							catch (IllegalArgumentException ex)
			        		{
								System.out.println("Selection out of range. Try again:");
			        		}
							break;
						
					case AddPassenger:
						PassengerOptions passengerOptions = PassengerOptions.AddClassic;
						
						while (passengerOptions != PassengerOptions.AddElitePlus)
							try
							{
								passengeroptions();
								
								passengerOptions = PassengerOptions.values()[Integer.parseInt(input.nextLine().trim()) - 1];
								
								switch (passengerOptions)
								{
									case AddClassic://classic
										
										expenseArray.add(new Classic());
										passengerOptions = PassengerOptions.AddElitePlus;
										break;
									case AddElite://elite
										
										expenseArray.add(new Elite());
										passengerOptions = PassengerOptions.AddElitePlus;
										break;
									case AddElitePlus://elite plus
										
										expenseArray.add(new ElitePlus());
										passengerOptions = PassengerOptions.AddElitePlus;
										break;
									
									default:
					                    System.out.println("Selection out of range. Try again");
								}
								passengerIndex++;
							}
							catch (IllegalArgumentException ex)
			        		{
								System.out.println("Selection out of range. Try again:");
			        		}
							break;
						
					case LoginStaff:
						System.out.printf("ID: ");
	    				String staffId = myScanner1.nextLine();
	    				boolean valid=false;
	    				for(int i=0; i<expenseArray.size(); i++)
	    				{
	    					if(expenseArray.get(i) instanceof Staff)
	    					{
		    					if(expenseArray.get(i) != null && ((Staff) expenseArray.get(i)).ID == staffId)
		    					{
		    						valid=true;
		    						
		    						System.out.printf("Password: ");
		    	    				String staffPassword = myScanner1.nextLine();
		    	    				boolean valid1=false;
		    	    				if(expenseArray.get(i) != null && (((Staff) expenseArray.get(i))).password.equals(staffPassword))
		    	    				{
		    	    					valid1=true;
		    	    							
		    	    					if(expenseArray.get(i) instanceof Admin)	
		    	    					{
		    	    						AdminMenu adminMenu = AdminMenu.AddFlight;
			    	    					
			    	    					while(adminMenu != AdminMenu.ExitAdmin)
			    	    						try
			    	    						{
			    	    							adminmenu();
			    	    							
			    	    							adminMenu = AdminMenu.values()[Integer.parseInt(input.nextLine().trim()) - 1];
			    	    							
			    	    							switch (adminMenu)
			    	    							{
			    	    								case AddFlight:
			    	    									FlightOptions flightOptions = FlightOptions.NonStop;
			    	    									
			    	    									while (flightOptions != FlightOptions.ThreeLeg)
			    	    										try
			    	    										{
			    	    											flightoptions();
			    	    											
			    	    											flightOptions = FlightOptions.values()[Integer.parseInt(input.nextLine().trim()) - 1];
			    	    											
			    	    											switch (flightOptions)
			    	    											{
			    	    												case NonStop://non-stop flight
			    	    													expenseArray.add(new OneLeg());
			    	    													flightOptions = FlightOptions.ThreeLeg;
			    	    													break;
			    	    												case TwoLeg://two-leg flight
			    	    													expenseArray.add(new TwoLeg());
			    	    													flightOptions = FlightOptions.ThreeLeg;
			    	    													break;
			    	    												case ThreeLeg://three-leg flight
			    	    													expenseArray.add(new ThreeLeg());
			    	    													flightOptions = FlightOptions.ThreeLeg;
			    	    													break;
			    	    												
			    	    												default:
			    	    								                    System.out.println("Selection out of range. Try again");
			    	    											}
			    	    											flightIndex++;
			    	    										}
			    	    										catch (IllegalArgumentException ex)
			    	    						        		{
			    	    											System.out.println("Selection out of range. Try again:");
			    	    						        		}
			    	    										break;
			    	    										
			    	    								case ShowFlightInfoA:
			    	    									ArrayList<Flight> TestFlight=new ArrayList<Flight>();  
			    	    									for(int c=0;c<expenseArray.size();c++)
			    	    									{
			    	    										if(expenseArray.get(c) instanceof Flight) {
			    	    											
			    	    											TestFlight.add((Flight)expenseArray.get(c));
				    	    									}
			    	    									}
			    	    									Collections.sort(TestFlight, Flight.departureComparator);
			    	    									for(int d=0;d<TestFlight.size();d++)
			    	    									{
			    	    										TestFlight.get(d).displayFlightInformation();
			    	    										System.out.println("");
			    	    									}
			    	    									
			    	    									break;
			    	    									
			    	    								case TakeOff:
			    	    									System.out.printf("Enter flight no: ");
			    	    				    				int flightid1 = myScanner1.nextInt();
			    	    				    				myScanner1.nextLine();
			    	    				    				
			    	    				    				boolean validto=false;
			    	    				    				
			    	    				    				int takeoff=0;
			    	    				    				for(int k=0; k<expenseArray.size(); k++)
			    	    				    				{
			    	    				    					if(expenseArray.get(k) instanceof Flight)
			    	    				    					{
			    	    					    					if(expenseArray.get(k) != null && ((Flight) expenseArray.get(k)).getflightNo() == flightid1)
			    	    					    					{
			    	    					    						validto=true;
			    	    					    						
			    	    					    						for(int l=0; l<checkInArray.size(); l++)
			    	    					    						{
			    	    					    							if(checkInArray.get(l) != null && checkInArray.get(l).valid == true)
			    	    					    							{
			    	    					    								takeoff = takeoff + checkInArray.get(l).weightOfLuggage;
			    	    					    								takeoff = takeoff + 80;	
			    	    					    							}
			    	    					    						}
			    	    					    						if(takeoff > ((Flight) expenseArray.get(k)).getmaxLoadOfPlane())
			    	    					    						{
			    	    					    							System.out.println("Plane cannot take off");
			    	    					    						}
			    	    					    						else
			    	    					    						{
			    	    					    							System.out.printf("Plane can take off. (%d <= %d)\n",takeoff,((Flight) expenseArray.get(k)).getmaxLoadOfPlane());
			    	    					    						}
			    	    					    					}
			    	    				    					}
			    	    				    				}
			    	    				    				if(!validto)
			    	    				    				{
			    	    				    					System.out.println("No such flight is found!");
			    	    				    				}
			    	    				    				break;
			    	    									
			    	    								case Expenses:
			    	    									double totalExpense=0.0;
			    	    				                	for(int m=0; m<expenseArray.size(); m++)
			    	    				                	{
			    	    				                		if(expenseArray.get(m).computeExpense()!=0.0)
			    	    				                		{
			    	    				                			totalExpense += expenseArray.get(m).computeExpense();
			    	    				                		}
			    	    				                	}
			    	    				                	System.out.printf("Total expense is %.0f\n",totalExpense);
			    	    				                	break;
			    	    				                	
			    	    								case SwitchUserAdmin:
			    	    									adminMenu = AdminMenu.ExitAdmin;
			    	    									break;
			    	    									
			    	    								case ExitAdmin:
			    	    									break;
			    	    									
			    	    								default:
			    	    									System.out.println("Selection out of range. Try again: ");
			    	    							}
			    	    						}
			    	    						catch (IllegalArgumentException ex) {
			    	    							System.out.println("Selection out of range. Try again: ");}
			    	    						break;
		    	    					}
		    	    					else//checkincounter
		    	    					{
		    	    						CheckInCounterMenu checkincounterMenu = CheckInCounterMenu.ShowFlightInfoC;
			    	    					
			    	    					while(checkincounterMenu != CheckInCounterMenu.ExitCounter)
			    	    						try
			    	    						{
			    	    							checkincountermenu();
			    	    							
			    	    							checkincounterMenu = CheckInCounterMenu.values()[Integer.parseInt(input.nextLine().trim()) - 1];
			    	    							
			    	    							switch (checkincounterMenu)
			    	    							{
			    	    								case ShowFlightInfoC:
			    	    								
			    	    									ArrayList<Flight> TestFlight=new ArrayList<Flight>();  
			    	    									for(int c=0;c<expenseArray.size();c++)
			    	    									{
			    	    										if(expenseArray.get(c) instanceof Flight) {
			    	    											
			    	    											TestFlight.add((Flight)expenseArray.get(c));
				    	    									}
			    	    									}
			    	    									Collections.sort(TestFlight, Flight.departureComparator);
			    	    									for(int d=0;d<TestFlight.size();d++)
			    	    									{
			    	    										TestFlight.get(d).displayFlightInformation();
			    	    										System.out.println("");
			    	    									}
			    	    									
			    	    									break;
			    	    									
			    	    								case ProcessCheckIn:
			    	    									System.out.printf("Enter ticket no: ");
			    	    				    				int tid = myScanner1.nextInt();
			    	    				    				myScanner1.nextLine();
			    	    				    				int tempcheckinsum,tempdepsum,tempdiff;
			    	    				    				
			    	    				    				for (int n=0; n<ticketArray.size(); n++) {
			    	    				    					
			    	    				    					if (ticketArray.get(n) != null && ticketArray.get(n).getticketNo() == tid) 
			    	    				    					{
			    	    				    						tempdepsum = (ticketArray.get(n).flight.departureTime.hour * 60) + ticketArray.get(n).flight.departureTime.minute;
			    	    				    						
			    	    				    						tempcheckinsum = (checkInArray.get(n).checkInTime.hour * 60) + checkInArray.get(n).checkInTime.minute;
			    	    				    						tempdiff = tempdepsum - tempcheckinsum;
			    	    				    						
			    	    				    						if(tempdiff < 30)
			    	    				    						{
			    	    				    							System.out.println("Check is declined!!");
			    	    				    						}
			    	    				    						else
			    	    				    						{
			    	    				    							checkInArray.get(n).valid = true;
			    	    				    						}
			    	    				    					}
			    	    				    				}	
			    	    				                    break;
			    	    				                    
			    	    								case ValidCheckIn:
			    	    									for(int o=0; o<checkInArray.size(); o++)
			    	    				    				{
			    	    				    					if(checkInArray.get(o) != null && checkInArray.get(o).valid == true)
			    	    				    					{
			    	    				    						checkInArray.get(o).displaycheckinInfo();
			    	    				    						System.out.printf("Ticket No # %d\n",ticketArray.get(o).getticketNo());
			    	    				    						System.out.printf("From %s to %s\n",ticketArray.get(o).flight.getoriginCity(),ticketArray.get(o).flight.destinationCity);
			    	    				    						System.out.printf("Departure Time:\t");
			    	    				    						ticketArray.get(o).flight.departureTime.displaydateInfo();
			    	    				    						System.out.printf("\nArrival Time:\t");
			    	    				    						ticketArray.get(o).flight.arrivalTime.displaydateInfo();
			    	    				    						System.out.printf("\nCheck-In Time:\t");
			    	    				    						checkInArray.get(o).checkInTime.displaydateInfo();
			    	    				    						System.out.printf("\nLuggage Weight:\t%d",checkInArray.get(o).weightOfLuggage);
			    	    				    						
			    	    				    						System.out.printf("\n");
			    	    				    					}
			    	    				    				}
			    	    				                    break;
			    	    				                    
			    	    								case SwitchUserCounter:
			    	    									checkincounterMenu = CheckInCounterMenu.ExitCounter;
			    	    									break;
			    	    								case ExitCounter:
			    	    									break;
			    	    								default:
			    	    									System.out.println("Selection out of range. Try again: ");
			    	    							}
			    	    						}
			    	    						catch (IllegalArgumentException ex) {
			    	    							System.out.println("Selection out of range. Try again: ");}
			    	    						break;
		    	    					}
		    	    				}
		    	    				if(!valid1)
		    	    					System.out.println("Wrong password");
		    					}
	    					}
	    				}
	    				if(!valid)
	    					System.out.println("Wrong ID");
						break;
						
					case LoginPassenger:
						System.out.printf("ID: ");
	    				String passengerId = myScanner1.nextLine();
	    				boolean valid2=false;
	    				for(int i=0; i<expenseArray.size(); i++)
	    				{
	    					if(expenseArray.get(i) instanceof Passenger)
	    					{
		    					if(expenseArray.get(i) != null && ((Passenger) expenseArray.get(i)).ID == passengerId)
		    					{
		    						valid2=true;
		    						
		    						System.out.printf("Password: ");
		    	    				String passengerPassword = myScanner1.nextLine();
		    	    				boolean valid3=false;
		    	    				if(expenseArray.get(i) != null && ((Passenger) expenseArray.get(i)).password.equals(passengerPassword))
		    	    				{
		    	    					valid3=true;
		    	    							
		    	    					PassengerMenu passengerMenu = PassengerMenu.ShowFlightInfoP;
		    	    					
		    	    					while(passengerMenu != PassengerMenu.ExitPassenger)
		    	    						try
		    	    						{
		    	    							passengermenu();
		    	    							
		    	    							passengerMenu = PassengerMenu.values()[Integer.parseInt(input.nextLine().trim()) - 1];
		    	    							
		    	    							switch (passengerMenu)
		    	    							{
		    	    								case ShowFlightInfoP:
		    	    									
		    	    									ArrayList<Flight> TestFlight=new ArrayList<Flight>();  
		    	    									for(int c=0;c<expenseArray.size();c++)
		    	    									{
		    	    										if(expenseArray.get(c) instanceof Flight) {
		    	    											
		    	    											TestFlight.add((Flight)expenseArray.get(c));
			    	    									}
		    	    									}
		    	    									Collections.sort(TestFlight, Flight.departureComparator);
		    	    									for(int d=0;d<TestFlight.size();d++)
		    	    									{
		    	    										TestFlight.get(d).displayFlightInformation();
		    	    										System.out.println("");
		    	    									}
		    	    									
		    	    									break;
		    	    									
		    	    								case BuyTicket:
		    	    									System.out.printf("Enter the flight no: ");
		    	    				    				int flightid = myScanner1.nextInt();
		    	    				    				myScanner1.nextLine();
		    	    				    				boolean valid5=false;
		    	    				    				for(int c=0; c<expenseArray.size(); c++)
		    	    				    				{
		    	    				    					if(expenseArray.get(c) instanceof Flight)
		    	    				    					{
		    	    					    					if(expenseArray.get(c) != null && ((Flight) expenseArray.get(c)).getflightNo() == flightid)
		    	    					    					{
		    	    					    						valid5=true;
		    	    					    						
		    	    					    						System.out.printf("ID: ");
		    	    					    	    				String Id = myScanner1.nextLine();
		    	    					    	    				boolean valid4=false;
		    	    					    	    				for(int z=0; z<expenseArray.size(); z++)
		    	    					    	    				{
		    	    					    	    					if(expenseArray.get(z) instanceof Passenger)
		    	    					    	    					{
		    	    					    	    						if(expenseArray.get(z) != null && ((Passenger) expenseArray.get(z)).ID == Id)
		    	    					    	    						{
		    	    					    	    							valid4=true;
		    	    						    	    						ticketArray.add(new Ticket());
		    	    								    						ticketArray.get(customerCount).flight=(Flight) expenseArray.get(c);
		    	    								    						
		    	    								    						ticketArray.get(customerCount).setticketNo(customerCount+1);
		    	    					    	    						}
		    	    					    	    					}
		    	    					    	    				}
		    	    					    	    				if(!valid4)
		    	    					    	    				{
		    	    					    	    					System.out.println("No passenger");
		    	    					    	    					break;
		    	    					    	    				}
		    	    					    	    				
		    	    					    	    				System.out.printf("Your ticket no is: %d\n",ticketArray.get(customerCount).getticketNo());
		    	    					    						customerCount++;
		    	    					    						break;
		    	    					    					}
		    	    				    					}
		    	    				    				}
		    	    				    				if(!valid5)
		    	    				    					System.out.println("No such flight");
		    	    				                    break;
		    	    				                    
		    	    								case RequestCheckIn:
		    	    									System.out.printf("Enter your ticket no: ");
		    	    				    				int ticketid = myScanner1.nextInt();
		    	    				    				myScanner1.nextLine();
		    	    				    				
		    	    				    				boolean valid6=false;
		    	    				    				for (chIndex=0; chIndex<ticketArray.size(); chIndex++) {
		    	    				    					
		    	    				    					if (ticketArray.get(chIndex) != null && ticketArray.get(chIndex).getticketNo() == ticketid) 
		    	    				    					{
		    	    				    						valid6=true;
		    	    				    						
		    	    				    						checkInArray.add(new CheckIn());
		    	    				    						checkInArray.get(chIndex).ticket=ticketArray.get(chIndex);
		    	    				    						
		    	    				    						chIndex++;
		    	    				    						break;
		    	    				    					}
		    	    				    				}
		    	    				    				if(!valid6)
		    	    				    					System.out.println("No such ticket!");	
		    	    				                    break;
		    	    				                    
		    	    								case SwitchUserPassenger:
		    	    									passengerMenu = PassengerMenu.ExitPassenger;
		    	    									break;
		    	    								case ExitPassenger:
		    	    									break;
		    	    								default:
		    	    									System.out.println("Selection out of range. Try again: ");
		    	    							}
		    	    						}
		    	    						catch (IllegalArgumentException ex) {
		    	    							System.out.println("Selection out of range. Try again: ");}
		    	    						break;
		    	    					
		    	    				}
		    	    				if(!valid3)
		    	    					System.out.println("Wrong password");
		    					}
	    					}
	    				}
	    				if(!valid2)
	    					System.out.println("Wrong ID");
						break;
						
					case ExitMain:
						break;
						
					default:
						System.out.println("Selection out of range. Try again: ");
				}
			}
			catch (IllegalArgumentException ex) {
				System.out.println("Selection out of range. Try again: ");}
	}
	
	public static void mainmenu()
    {
		System.out.println("\n-Main Menu-");
        System.out.println("\n1. Add a staff.");
        System.out.println("2. Add a passenger.");
        System.out.println("3. Staff login.");
        System.out.println("4. Passenger login.");
        System.out.println("5. Exit.\n");
        System.out.printf("Your choice: ");
    }
	public static void adminmenu()
    {
		System.out.println("\n-Admin Menu-");
        System.out.println("\n1. Add a new flight.");
        System.out.println("2. Show flight information.");
        System.out.println("3. Calculate take-off load.");
        System.out.println("4. Calculate expenses.");
        System.out.println("5. Switch users.");
        System.out.println("6. Exit.\n");
        System.out.printf("Your choice: ");
    }
	public static void checkincountermenu()
    {
		System.out.println("\n-Check In Counter Menu-");
        System.out.println("\n1. Show flight information.");
        System.out.println("2. Process a check-in.");
        System.out.println("3. Display valid check-ins.");
        System.out.println("4. Switch users.");
        System.out.println("5. Exit.\n");
        System.out.printf("Your choice: ");
    }
	public static void passengermenu()
    {
		System.out.println("\n-Passenger Menu-");
        System.out.println("\n1. Show flight information.");
        System.out.println("2. Buy ticket.");
        System.out.println("3. Request a check-in.");
        System.out.println("4. Switch users.");
        System.out.println("5. Exit.\n");
        System.out.printf("Your choice: ");
    }
	public static void staffoptions()
	{
		System.out.println("\n1. Add Admin.");
        System.out.println("2. Add Check In Counter.\n");
        System.out.printf("Your choice: ");
	}
	public static void passengeroptions()
	{
		System.out.println("\n1. Add Classic Passenger.");
        System.out.println("2. Add Elite Passenger.");
        System.out.println("3. Add Elite Plus Passenger.\n");
        System.out.printf("Your choice: ");
	}
	public static void flightoptions()
	{
		System.out.println("\n1. Create non-stop flight.");
        System.out.println("2. Create a two-leg flight.");
        System.out.println("3. Create a three-leg flight.\n");
        System.out.printf("Your choice: ");
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
