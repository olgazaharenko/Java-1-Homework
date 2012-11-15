package OZA_JAVA1_Homework;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * myOperationsWithFile class methods:
 * CreateNewFile();
 * ReadFromFile();
 * WriteToFile(String newLineToRecord).
 */

public class myFile {
	
	myFile(String fileName){
		File f = new File(fileName);
	}

public void doBackup(String fileName, String myBackup) throws IOException {
	
	FileChannel fChannel = new FileInputStream(fileName).getChannel();
	FileChannel fbChannel = new FileOutputStream(myBackup).getChannel();
	fChannel.transferTo(0, fChannel.size(), fbChannel);
	fChannel.close();
	fbChannel.close();
}
	
}
