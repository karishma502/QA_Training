package com.ddf.utils;

/*
 * 
 * This class is not going to be used in Framework.
 * 
 */
public class ReadTestData {

	public static void main(String args[]) {
		ReadExcelDataFile readdata = new ReadExcelDataFile(
				System.getProperty("user.dir") + "/src/main/java/testData/TestData_Testmanagement.xlsx");
		String sheetName = "Feature 5";
		String testName = "Test Eight";

		//Find Start Row of TestCase
		int startRowNum = 0;
		//Code is reading first column of the sheet - and checking whether test case name is present 
		
		while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
			startRowNum++;
		}
		System.out.println("Test Starts from Row Number : " + startRowNum);
		
		int startTestColumn = startRowNum+1;
		int startTestRow = startRowNum+2;
		
		//Find Number of Rows of TestCase
		int rows = 0;
		
		while (!readdata.getCellData(sheetName, 0, startTestRow+rows).equals("")) {
			rows++;
		}
		System.out.println("Total Numbe of Rows in Test : " +testName + " is - " +rows);
		
		//Find Number of Columns in Test
		int colmns=0;
		System.out.println("Columns are : ");
		while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) {
			System.out.print(readdata.getCellData(sheetName, colmns, startTestColumn)+" | ");
			colmns++;
		}
		System.out.println(" ");
		System.out.println("Total Number of Columns in Test : " +testName + " is - " +colmns);
		System.out.println("Test Data");
		for (int rowNumber=startTestRow; rowNumber<=startTestColumn+rows; rowNumber++) {
			for (int colNumber=0; colNumber<colmns; colNumber++) {
				//System.out.println(readdata.getCellData(sheetName, colNumber, rowNumber));
				System.out.print(readdata.getCellData(sheetName, colNumber, rowNumber)+" | ");
			}
			System.out.println(" ");
		}
	}
	
	

}
