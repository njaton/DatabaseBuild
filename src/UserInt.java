import java.util.Scanner;

/**
 * Houses the code that handles the user interface with the database.
 * @author nick
 *
 */
public class UserInt
{
	/**
	 * Waits for the user to give a command and then responds accordingly. 
	 * @throws Exception
	 */
	public static void waiting() throws Exception
	{
		Scanner user_input = new Scanner(System.in);
		boolean temp = false;
		
		menu(); 
		
		while (temp == false)
		{
			String command = user_input.nextLine();
			if (command.equals("add"))
			{
				whichAdd();
			}
			
			if (command.equals("close"))
			{
				main.exit();
			}
			
			if (command.equals("help"))
			{
				menu(); 
			}
			
			if (command.equals("delete"))
			{
				ContDelete();
			}
		}
	}
	
	/**
	 * Confirm the user wants to delete data.
	 * @throws Exception
	 */
	public static void ContDelete() throws Exception 
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Confirm Delete (Y/N)");
		String command = user_input.nextLine();
		
		if (command.equals("Y"))
		{
			DataFill.dataDelete();
		}
		else
		{
			waiting();
		}
	}
	
	/**
	 * Determine if the user wants to add by .txt file or input. 
	 * @throws Exception
	 */
	public static void whichAdd() throws Exception 
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("Would you like to add from .txt file or by user input? (file / input)"
				+ "\nElse press anything to be sent to main menu");
		String option = user_input.next();
		
		if (option.equals("file"))
		{
			DataFill.txtAdd();
			waiting();
		}
		else if (option.equals("input"))
		{
			addData();
			waiting();
		}
		else 
		{
			waiting();
		}
	}
	
	/**
	 * Allows the user to build rows at once.
	 * @throws Exception
	 */
	public static void addData() throws Exception
	{
		Scanner user_input = new Scanner(System.in);
		System.out.println("How many species would you like to add");
		String command = user_input.next();
		
		int commandInt = Integer.parseInt(command);
		
		if (commandInt == 1)
		{
			DataFill.parsing();
			waiting();
		}
		else if (commandInt > 1) 
		{
			for (int i = 0; i < commandInt; i++)
			{
				DataFill.parsing();
			}
			waiting();
		}
		else
		{
			waiting();
		}
	}
	
	/**
	 * Displays a simple print menu
	 */
	public static void menu()
	{
		System.out.println("The following is the menu:\n"
				+ "add - allows the user to add data\n"
				+ "close - shuts down the whole program.\n"
				+ "help - gives menu\n"
				+ "delete - clears table\n");
	}
}
