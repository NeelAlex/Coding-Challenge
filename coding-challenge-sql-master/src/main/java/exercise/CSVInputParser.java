package exercise;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVInputParser {
	
	public static List<List<String>> readFile(String fileName){
		List<List<String>> records = new ArrayList<List<String>>();
		try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/" + fileName))) {
			String[] values = null;
	        while ((values = reader.readNext()) != null) {
	            records.add(Arrays.asList(values));
	        }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return records;
	}
}
