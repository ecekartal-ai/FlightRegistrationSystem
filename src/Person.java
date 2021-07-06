import java.util.Locale;
import java.util.Scanner;

abstract class Person implements Expense {
	static String name;
	static String surname;
	String ID;
	String password;
	Scanner myScanner = new Scanner(System.in).useLocale(Locale.US);
	
	public Person()
	{	
			
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

