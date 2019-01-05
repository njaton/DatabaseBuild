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
				DataFill.parsing();
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
