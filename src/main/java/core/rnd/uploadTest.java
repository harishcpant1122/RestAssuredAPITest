package core.rnd;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class uploadTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Test uploadTest...");
		final String CSV_FILE_PATH = "./result.csv";
		
		File file = new File(CSV_FILE_PATH); 
        Scanner sc = new Scanner(System.in); 
        try { 
            // create FileWriter object with file as parameter 
            FileWriter outputfile = new FileWriter(file); 
  
            // create CSVWriter with ';' as separator 
            CSVWriter writer = new CSVWriter(outputfile, ';', 
                                             CSVWriter.NO_QUOTE_CHARACTER, 
                                             CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                             CSVWriter.DEFAULT_LINE_END); 
  
            // create a List which contains Data 
            List<String[]> data = new ArrayList<String[]>(); 
  
            System.out.println("Enter no of rows"); 
            //int noOfRow = Integer.parseInt(sc.nextLine()); 
            System.out.println("Enter Data"); 
            for (int i = 0; i < 2; i++) { 
                String row = sc.nextLine(); 
                String[] rowdata = row.split(" "); 
                data.add(rowdata); 
            } 
  
            writer.writeAll(data); 
  
            // closing writer connection 
            writer.close(); 
        }catch(Exception e) {}
	}
}
