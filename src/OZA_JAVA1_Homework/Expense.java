package OZA_JAVA1_Homework;

public class Expense {

	private String date;
	private String sum;
	private String description;
	
	private String msgEnterData = "Введите дату:";
	private String msgEnterSum = "Введите сумму:";
	private String msgEnterDescription = "Введите комментарий к расходам:";
		
	Expense() {
		setDate(ReadUserInputHelper.getUserInput(msgEnterData));
		setSum(ReadUserInputHelper.getUserInput(msgEnterSum));
		setDescription(ReadUserInputHelper.getUserInput(msgEnterDescription));
	}
	
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSum() {
		return this.sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
