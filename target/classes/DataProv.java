package resources;

import org.testng.annotations.DataProvider;

public class DataProv {

	@DataProvider(name="testdata")
	public Object[][] getData() {
		Object[][] obj= new Object[][]
				{
			{"hello"},{"&*(!"} 
				};
				return obj;
		
	}
	
	
	
}
