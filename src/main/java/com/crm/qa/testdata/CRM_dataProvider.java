package com.crm.qa.testdata  ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.testng.annotations.DataProvider;


public class CRM_dataProvider {

	@DataProvider(name="dp_Invalidlogin")
	public static Iterator<Object[]> getInvaliddata() throws Exception
	{
		return Commondp_logic("Login","InvalidLogin");
	}
	@DataProvider(name="dp_validlogin")
	public static Iterator<Object[]> getvaliddata() throws Exception
	{
		return Commondp_logic("Login","ValidLogin");
		
	}
	public static Iterator<Object[]> Commondp_logic(String Sheetname,String Sname) throws Exception
	{
		String projectpath = System.getProperty("user.dir");
		ExcelRW x1 = new ExcelRW(projectpath+"\\src\\main\\java\\com\\crm\\qa\\testdata\\Testdata.xlsx");
		int colcount = x1.getColum(Sheetname);
		int rowcount = x1.getRow(Sheetname);
		
		List<Object[]> arr_list= new ArrayList<Object[]>();
		for(int i=1;i<=rowcount;i++)
		{
			String Execute_flag = x1.readCell(Sheetname, i, 2);
			String Script_name = x1.readCell(Sheetname, i, 3);
			
			if(Execute_flag.equalsIgnoreCase("Y") && (Script_name.equalsIgnoreCase(Sname)))
			{
				Object[] x = new Object[1];
				Map<String,String> dmap = new HashMap<String,String>();
				for(int j= 0;j<colcount;j++)
				{
					 String Skey = x1.readCell(Sheetname, 0, j);
					 String Value = x1.readCell(Sheetname, i, j);
					 dmap.put(Skey, Value);
				}
				x[0]=dmap;
				arr_list.add(x);
			}
			
		}
		return arr_list.iterator();
	}
}
