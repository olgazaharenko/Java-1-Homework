package ExpensesTask;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * myFile class methods:
 * doBackupFromTo(String fileName, String myBackup)
 */

public class myFile {
	
myFile(String fileName){
	File f = new File(fileName);
}

public void doBackupFromTo(String fileName, String myBackup) throws IOException {
	
	FileChannel fChannel = new FileInputStream(fileName).getChannel();
	FileChannel fbChannel = new FileOutputStream(myBackup).getChannel();
	fChannel.transferTo(0, fChannel.size(), fbChannel);
	fChannel.close();
	fbChannel.close();
}

public void printFileNotFound () {
	System.out.println("File with expenses not found.");
	System.out.println("Please start to add expenses first.");
}

}
