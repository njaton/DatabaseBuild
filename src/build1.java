import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *  This class will hold the code that does the actual 
 *  building of the database 
 *  
 *  Written by: Nicholas Jaton 
 */
public class build1 
{	
	/**
	 * Builds a connection to the database that will be used. 
	 * @return conn
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception
	{
		try 
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/DB1";
			String username = "root";
			String password = "MyNewPass";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected to DB1");
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * If the table has not been created it will create the table. 
	 * @throws Exception
	 */
	public static void table() throws Exception
	{
		try 
		{
			Connection conn = getConnection();	
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS"
					+ " `DB1`.`SnakeSpecies` (\n"  
					+ "  `id` INT NOT NULL AUTO_INCREMENT,\n" 
					+ "  `Species` VARCHAR(255) NULL,\n" 
					+ "  PRIMARY KEY (`id`));" );
			create.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Updated");
		}
	}
	
	/**
	 * Adds the location of the reptile in the data 
	 * @throws Exception
	 */
	public static void addLoc() throws Exception
	{
		Connection conn = getConnection();
		
		try 
		{
			PreparedStatement temp = conn.prepareStatement("select count(Location) \n"
				+ "from db1.SnakeSpecies \n");
			
			ResultSet rs = temp.executeQuery();
			System.out.println(rs);
			System.out.print("Location is in table");
		}
		
		catch(Exception e)
		{
			PreparedStatement loc = conn.prepareStatement("ALTER TABLE "
					+ "DB1.SnakeSpecies \n"
					+ "ADD COLUMN Location VARCHAR(255) AFTER Species;");
			loc.executeUpdate();
			System.out.print("Location was updated");
			System.out.print("col built");
		}
	}
	
	/**
	 * Builds the column indicating if the reptile uses venom
	 * @throws Exception
	 */
	public static void addVenom() throws Exception
	{
		Connection conn = getConnection();
		
		try 
		{
			PreparedStatement temp = conn.prepareStatement("select count(Venom) \n"
				+ "from db1.SnakeSpecies \n");
			
			ResultSet rs = temp.executeQuery();
			System.out.println(rs);
			System.out.print("Venom is in table");
		}
		
		catch(Exception e)
		{
			PreparedStatement loc = conn.prepareStatement("ALTER TABLE "
					+ "DB1.SnakeSpecies \n"
					+ "ADD COLUMN Venom VARCHAR(45) AFTER Location;");
			loc.executeUpdate();
			System.out.print("Venom was updated");
			System.out.print("col built");
		}
	}
	
	/**
	 * Adds a new column for color
	 * @throws Exception
	 */
	public static void addColor() throws Exception 
	{
		Connection conn = getConnection();
		
		try 
		{
			PreparedStatement temp = conn.prepareStatement("select count(Color) \n"
				+ "from db1.SnakeSpecies \n");
			
			ResultSet rs = temp.executeQuery();
			System.out.println(rs);
			System.out.print("Color is in table");
		}
		
		catch(Exception e)
		{
			PreparedStatement loc = conn.prepareStatement("ALTER TABLE "
					+ "DB1.SnakeSpecies \n"
					+ "ADD COLUMN Color VARCHAR(45) AFTER Venom;");
			loc.executeUpdate();
			System.out.print("Color was updated");
			System.out.print("col built");
		}
		
	}
}
