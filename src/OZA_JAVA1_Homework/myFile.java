package OZA_JAVA1_Homework;

import java.io.*;

/**
 * myOperationsWithFile class methods:
 * CreateNewFile();
 * ReadFromFile();
 * WriteToFile(String newLineToRecord).
 */

class myFile {
	
	private String myFinanceFileName = "myfinance.txt";
	private String myBackup = "myfinance.bak";
	
	
	//конструктор класса создает новый файл и его бекап
	myFile() {
		File f = new File(myFinanceFileName);
		File fb = new File(myBackup);
	}

	
	public static void CreateNewFile(String NameForNewFile) throws IOException {
		
		
	  }

	
	public static String ReadFromFile(String NameForFile) throws IOException {
		
		String readLine = "";
		
		return readLine;
	}
	
	
	
	
	public static void WriteToFile(String newLineToRecord, String NameForFile) throws IOException {
		
	

	}

}
