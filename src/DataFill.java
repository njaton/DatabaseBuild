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
	public static String getString()
	{
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Please input data in the following format"
				+ "\nSpecies,Location,Venom" );
		
		String dataString = user_input.nextLine();
		return dataString;
	}
	
	public static void parsing() throws Exception
	{
		String preProcessed = getString();
		String a = "";
		String b = "";
		String c = "";
		
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
			count = count + 1; 
		}
		Connection conn = build1.getConnection();
		
		try 
		{
			PreparedStatement filling = conn.prepareStatement("INSERT INTO "
					+ "DB1.SnakeSpecies(Species, Location, Venom)"
					+ " VALUES('" + a +"','" + b + "','" + c + "');");
			
			System.out.println(filling);
			filling.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
}
