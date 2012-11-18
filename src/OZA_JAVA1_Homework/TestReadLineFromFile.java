package OZA_JAVA1_Homework;

//Чтение (указанного пользователем) файла
//Построчное чтение и вывод на консоль его содержимого
//Перезапись файла 
import java.io.*;
class TestReadLineFromFile
{
public static void main(String[] args)
{
	String sFileName=""; // Строка для имени файла
 System.out.println("\nFILE TEST\n");	
 String stroka="\n";

	try
	{
	// OutputStreamWriter позволяет явно указать кодировку
	OutputStreamWriter OSW = new OutputStreamWriter(System.out, "Cp866");
	PrintWriter         PW = new PrintWriter(OSW, true); 
 PW.println("\nВведите имя файла:");
 
 // InputStreamWriter позволяет явно указать кодировку
 InputStreamReader ISR = new InputStreamReader(System.in, "Cp866");
 BufferedReader     BR = new BufferedReader(ISR); 

 // ПОСТРОЧНЫЙ ВВОД (ИМЕНИ ФАЙЛА)
 sFileName = BR.readLine(); // читаем строку (имя файла) 
 PW.println("\nИщем файл "+sFileName);
 try
 { 
    FileInputStream in = new FileInputStream(sFileName);
    PW.println("\nФайл "+sFileName+" найден.\n"); 
    PW.println("\nСодержимое файла "+sFileName+":\n"); 
    
    // Построчно читаем файл и печатаем его содержимое  
    FileReader FR = new FileReader(sFileName);
    BufferedReader BRf = new BufferedReader(FR);
    do
     {
     stroka=BRf.readLine();
     if(stroka!=null) {PW.println(stroka);}
     }
     while(stroka!=null);

    // Печатаем в файл нашу строку 3 раза 
    FileWriter FW = new FileWriter(sFileName);
    BufferedWriter BWf = new BufferedWriter(FW);
    BWf.write("А ТЕПЕРЬ ЗДЕСЬ НОВОЕ СОДЕРЖИМОЕ!!!");
    BWf.newLine(); // переходим на новую строку
    BWf.write("А ТЕПЕРЬ ЗДЕСЬ НОВОЕ СОДЕРЖИМОЕ!!!");
    BWf.newLine(); // переходим на новую строку
    BWf.write("А ТЕПЕРЬ ЗДЕСЬ НОВОЕ СОДЕРЖИМОЕ!!!");
    BWf.close();// не забудем закрыть файл

    PW.println("\n\nФАЙЛ "+sFileName+" ПЕРЕЗАПИСАН.\n\n\n");
 
 
 }//try
  catch (FileNotFoundException e) 
 { 
  PW.println("Файл "+sFileName+" не найден."); 
 }//catch (FileNotFoundException e) //catch
 }//try
 catch(Exception e)
 {
	System.out.println("Something is wrong....");
 }//catch(Exception e)
}//main
}//testFile1