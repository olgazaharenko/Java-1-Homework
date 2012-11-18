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
	
	public void addExpenseToRegister() {
		list.add(myExpense);
	}
	
	public void addExpenseToRegister(int l) {
		list.add(l, myExpense);
	}

	public void addExpenseToRegister_test () throws IOException {
		
		//создаем файловую переменную
		File f = new File(myFinanceFileName);
				
		//создаем переменную для операций с регистром расходов 
		ExpenseRegister myFinance = new ExpenseRegister();
		
		//если файл не существует (первый ввод расхода)
		if (!f.exists()) {

			myFinance.addExpenseToRegister();
			
			String tmpStr = myFinance.getExpenseAsString();
			myFinance.writeStringToFile(tmpStr, myFinanceFileName);
		}
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
