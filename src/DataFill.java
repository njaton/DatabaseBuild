import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

/**
 * This class will hold the method that fills in data based
 * off of the users request.
 * 
 * @author Nicholas Jaton
 *
 */
public class DataFill 
{	
	/**
	 * Gets the data from the user so that it can be entered into the database. 
	 * @return dataString 
	 */
	public static String getString()
	{
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Please input data in the following format"
				+ "\nSpecies,Location,Venom,Color" );
		
		String dataString = user_input.nextLine();
		return dataString;
	}
	
	/**
	 * Parses dataString so that it can be placed into the database. 
	 * @throws Exception
	 */
	public static void parsing() throws Exception
	{
		String preProcessed = getString();
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		
		String[] token = preProcessed.split(",");
		
		int count = 0;
		
		for (String t : token)
		{
			if (count == 0)
			{
				a = t;
			}
			else if (count == 1)
			{
				b = t; 
			}
			else if (count == 2)
			{
				c = t; 
			}
			else if (count == 3)
			{
				c = t;
			}
			count = count + 1; 
		}
		Connection conn = build1.getConnection();
		
		try 
		{
			PreparedStatement filling = conn.prepareStatement("INSERT INTO "
					+ "DB1.SnakeSpecies(Species, Location, Venom, Color)"
					+ " VALUES('" + a +"','" + b + "','" + c + "','" + d + "');");
			
			System.out.println(filling);
			filling.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	/**
	 * Deletes all data in table.
	 * @throws Exception
	 */
	public static void dataDelete() throws Exception 
	{
		Connection conn = build1.getConnection();
		try
		{
			PreparedStatement delete = conn.prepareStatement("DELETE FROM "
					+ "DB1.SnakeSpecies WHERE id > 0 ;");
			System.out.print("Removing current data");
			delete.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.print(e);
		}	
	}
}
