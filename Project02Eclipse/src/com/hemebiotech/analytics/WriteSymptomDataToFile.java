package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

	
	public WriteSymptomDataToFile() {
		
	}

	public void writeSymptoms(List<String> var1) throws IOException {
	
	        BufferedWriter var2 = new BufferedWriter(new FileWriter("result.out"));
	        Iterator var3 = var1.iterator();

	        while(var3.hasNext()) {
	            String var4 = (String)var3.next();
	            var2.write(var4);
	            var2.newLine();
	        }

	        var2.close();
	    }
		
}
