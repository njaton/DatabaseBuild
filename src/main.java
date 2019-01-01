/**
 * Main program that will be used to create a table 
 * using MySQL. 
 * 
 * Written by: Nicholas Jaton 
 */

public class main {

	public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome to the database builder");
		build1.table();
		build1.addLoc();
		build1.addVenom();
		
		DataFill.parsing();
	}
}
