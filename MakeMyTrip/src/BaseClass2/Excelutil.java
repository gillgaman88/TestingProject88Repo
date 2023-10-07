package BaseClass2;

import java.util.Hashtable;

import Filehandling.xlsx_Reader;

public class Excelutil {
	
	public static Object[][] getSignupData() {
    xlsx_Reader xls=new xlsx_Reader("E:\\selenium\\Opustime.xlsx");
	int rows=xls.getRowCount("Testdata");
	System.out.println("Total number of rows:" +" " +rows);
	int cols= xls.getColumnCount("Testdata");
	System.out.println("Total number of column:" +" " +cols);
	
	String TotalData=xls.getCellData("Testdata",1,2);
	System.out.println("Data where rows and columns matches:" +TotalData);
	
	Object Obj[][]=new Object[rows][1];
	Hashtable<String,String>table=null;
	
	for(int i=0;i<rows;i++){
	   table=new Hashtable<String,String>();
	   
	for (int j=0;j<cols;j++){
	String Key=xls.getCellData("Testdata", j, i);
	String Value=xls.getCellData("Testdata", j, i+1);
	table.put(Key, Value);
	   }
	Obj[i][0]=table;		   
	   }
	System.out.println();  
	
	return Obj;
	
	}
}

