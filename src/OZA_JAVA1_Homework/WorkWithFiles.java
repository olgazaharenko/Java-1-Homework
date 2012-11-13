package OZA_JAVA1_Homework;

import java.io.*;

/**
 * FilesHelper class methods:
 * CreateNewFile();
 * ReadFromFile();
 * WriteToFile(String newLineToRecord).
 */

public class WorkWithFiles {

	static String msgForUser1 = "New file ";
	static String msgForUser2 = " has been created to the current directory";
	static String msgForUser3 = "File ";
	static String msgForUser4 = " already exists.";
	
	public static void CreateNewFile(String NameForNewFile) {
		
		try {
			
			File f;
			f=new File(NameForNewFile);
		  
			if( !f.exists() ) {
				f.createNewFile();
				System.out.println(msgForUser1 + NameForNewFile + msgForUser2);
				}
			else {
				System.out.println(msgForUser3 + NameForNewFile + msgForUser4);
			}
			}
		catch (IOException e) {
			System.out.println ("IOException: " + e);
		}
	  }

	
	public static String ReadFromFile(String NameForFile) {
		
		
		String readLine = "";
		
		try {
			FileReader fr = new FileReader(NameForFile);
			BufferedReader br = new BufferedReader(fr);
			
			readLine = br.readLine();
			System.out.println(readLine);
			
			br.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return readLine;
	}
	
	
	public static String ReadFromFile1(String NameForFile) {
		String readLine = "";
		
	    try {
	       FileReader fr = new FileReader(NameForFile);
	       BufferedReader br = new BufferedReader(fr);

	       while (br.readLine() != null) {
				readLine = br.readLine();
				System.out.println(readLine);
	               }
	       br.close();
	       fr.close();
	           } 
	    catch (FileNotFoundException e) {
	        System.out.println("Файл " + NameForFile + " не найден");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return readLine;
	}
	
	
public static void WriteToFile(String newLineToRecord, String NameForFile) {
		
	try {
		FileWriter fw = new FileWriter(NameForFile);
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
