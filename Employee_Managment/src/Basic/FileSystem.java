package Basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

public class FileSystem {
	private final static String FILENAME = "/home/infoobjects/Documents/Employee.txt";
	
	 void mapLoad() throws IOException {
		BufferedReader reader = null;
		try {
			File file = new File(FILENAME);
			reader = new BufferedReader(new FileReader(file));
			String line =";";
			while((line = reader.readLine()) != null) {
		            if(line.equals("")) {
		            	continue;
		            }
		            String[] out = line.split(",");
		            Mapper.put(out[0],new Employee(out[0],out[1],out[2],out[3],out[4],out[5],out[6],out[7],out[8],out[9]));
		    }
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(reader != null) {
				reader.close();
			}
		}
		
	}
	
	 void writeMap() throws IOException {
		PrintWriter printWriter = null;
		try {
			FileWriter fileWriter = new FileWriter(FILENAME);
			printWriter = new PrintWriter(fileWriter);    
			String line = "";
			Iterator<Map.Entry<String, Employee>> itr = Mapper.iterate();
			while(itr.hasNext()) {
				Map.Entry<String, Employee> entry = itr.next(); 
				line = line + entry.getKey()+"," + entry.getValue().toString() + "\n";
			}
			printWriter.print(line);
			System.out.println("Done");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			printWriter.close();
		}	
	}
}
