import static org.junit.Assert.*;

import org.junit.Test;

public class Build1Test {

	@Test
	public void connectionTryTest() throws Exception 
	{
		build1 newBuild  = new build1();
		newBuild.getConnection();
	}
	
	@Test 
	public void tableTryTest() throws Exception
	{
		build1 newBuild = new build1();
		newBuild.table();
	}
	
	@Test 
	public void addLocTryTest() throws Exception
	{
		build1 newBuild = new build1();
		newBuild.addLoc();
	}
	
	@Test 
	public void addVenTryTest() throws Exception
	{
		build1 newBuild = new build1();
		newBuild.addVenom();
	}
	
	@Test 
	public void addColTryTest() throws Exception
	{
		build1 newBuild = new build1();
		newBuild.addColor();
	}

}
