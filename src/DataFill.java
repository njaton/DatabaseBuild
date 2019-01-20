import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.io.*;

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
	private static String getString()
	{
		String dataString;
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Please input data in the following format"
				+ "\nSpecies,Location,Venom,Color" );
		
		dataString = user_input.nextLine();
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
	 * Gets the users file location
	 */
	public static void txtAdd() throws Exception
	{ 
		System.out.println("Entered Textfile");
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Please enter your text location");
		String Location = user_input.nextLine();
		
		String data = readFile(Location);
		fileParse(data);
		UserInt.waiting();
	}
	
	/**
	 * Reads the file into a string and prints data.
	 */
	public static String readFile(String Location) throws Exception
	{
		File fileLoc = new File(Location);
		BufferedReader b = new BufferedReader(new FileReader(fileLoc));
		
		String dataString; 
		String store = "";
		
		System.out.println("Data will be displayed below");
		while((dataString = b.readLine()) != null)
		{
			System.out.println(dataString);
			store += dataString;
		}
		return store;
	}
	
	/**
	 * Builds the SQL to upload the data from the txt file. 
	 */
	private static void fileParse(String incomingData) throws Exception
	{
		String txtData = incomingData;
		System.out.println(txtData);
		String a = "";
		String b = "";
		String c = "";
		String d = "";
		
		Connection conn = build1.getConnection();
		
		String[] token = txtData.split(",");
		
		int tempCounter = 1;
		for (String temp: token)
		{
			if (tempCounter == 1)
			{
				a = temp;
			}
			else if (tempCounter == 2)
			{
				b = temp; 
			}
			else if (tempCounter == 3)
			{
				c = temp; 
			}
			else if (tempCounter == 4)
			{
				d = temp;
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
				tempCounter = 0;
			}
			tempCounter = tempCounter + 1; 
		}
		//	/Users/nick/Desktop/Java/testingDocSnakeDatabase.txt/
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
