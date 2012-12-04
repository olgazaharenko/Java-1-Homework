package ExpensesTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ExpenseRegister {
	
	private String d = ";"; //разделитель значений
	private List <Expense> list = new ArrayList <Expense>();
	String myFinanceFileName = "myfinance.txt"; 
	String myBackup = "myfinance.bak"; 
	Expense myExpense = new Expense();
	
	//TODO: конструктор класса без new Expense();
	//только для доступа к методам класса
	// ExpenseRegister () {
	//	
	//}
	
	//ExpenseRegister (String fileName) {
	//	String dateOfToday = "";
	//	String sumOfToday = "";
	//	String descOfToday = "";
	//	Expense myExpense = new Expense(dateOfToday, sumOfToday, descOfToday);
	//}
	
	public void addExpenseToRegister() {
		list.add(myExpense);
	}
	
	public void addExpenseToRegister(int l) {
		list.add(l, myExpense);
	}
	
	public void removeExpenseFromRegister(Expense q) {
		list.remove(q);	
	}
	
	public void removeExpenseFromRegister(int l) {
		list.remove(l);	
	}
	
	public String getExpenseAsString () {
		String myExpenseAsString = myExpense.getDate() + d + myExpense.getSum() + d + myExpense.getDescription() + d;
		return myExpenseAsString;
	}
	
	public Expense setStringAsExpense (String q) {
		Expense myStringAsExpense = new Expense();
		StringTokenizer str = new StringTokenizer(q,d);
		
	     while(str.hasMoreTokens()){
	    	 
	    	 myStringAsExpense.setDate(str.nextToken());
	    	 myStringAsExpense.setSum(str.nextToken());
	    	 myStringAsExpense.setDescription(str.nextToken());
	}
		return myStringAsExpense;
	}	
	
	public void writeStringToFile (String x, String fileName) throws IOException {
		BufferedWriter myFileWriter = new BufferedWriter(new FileWriter(fileName));
		myFileWriter.write(x);
		myFileWriter.close();
	}
	
	public ArrayList<String> readStringFromFile (String fileName) throws IOException {
		FileReader myFileReader = new FileReader(fileName);
	    BufferedReader myBufferedReader = new BufferedReader(myFileReader);

	    ArrayList<String> tmpFinanceList = new ArrayList<String>();
	    
	    String stroka="\n";
	    int j = 0;
	    do
	       {
	       stroka=myBufferedReader.readLine();
	        	if(stroka!=null) {
		        	tmpFinanceList.add(j, stroka);
			        j++;
	        	}
	        }
	       	while(stroka!=null);
	      myBufferedReader.close();
		return tmpFinanceList;
	}

}
