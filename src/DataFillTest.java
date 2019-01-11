import static org.junit.Assert.*;

import org.junit.Test;

public class DataFillTest {

	@Test
	public void parsingExceptionTest() throws Exception
	{
		DataFill temp = new DataFill();
		temp.parsing();
	}

	/*
	 * WARNING, WILL DELETE DATA
	 */
	@Test
	public void deleteExceptionTest() throws Exception 
	{
		DataFill temp = new DataFill();
		temp.dataDelete();		
	}
}
