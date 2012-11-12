package OZA_JAVA1_Homework;

import java.io.*;

public class ExpenseInputHelper {

	static String myFinanceFileName = "myfinance.txt";
	
	public static String getUserInput(String prompt) {
		
		String inputLine = null;
		
		System.out.print(prompt + " ");
		
		try {
			
			BufferedReader is = new BufferedReader (new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) {
				return null;
			}
		}
		catch (IOException e) {
			System.out.println ("IOException: " + e);
		}
		return inputLine;
	}
	
	public static String ReadFromFile() {
		
		String readLine = "";
		
		try {
			FileReader fr = new FileReader(myFinanceFileName);
			BufferedReader br = new BufferedReader(fr);

			readLine = br.readLine();

			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return readLine;
	}
	
public static void WriteToFile(String newLineToRecord) {
		
	try {
		FileWriter fw = new FileWriter(myFinanceFileName);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(newLineToRecord);

		bw.close();
		fw.close();
		} 
	catch (IOException e) {
		e.printStackTrace();
		}
	}
}
