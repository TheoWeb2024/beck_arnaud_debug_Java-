package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Write in an output file after one analyze.
 */
public class WriteSymptomDataToFile implements ISymptomWriter{

	/**
	 * Write symptoms in a file named result.out.
	 * 
	 * @param elementsOfList: elements which have been analyzed and will be written 
	 */
	public void writeSymptoms(List<String> elementsOfList) throws IOException {   
	
	        BufferedWriter bufferedContent = new BufferedWriter(new FileWriter("result.out"));      
	        Iterator existingElement = elementsOfList.iterator();            

	        while(existingElement.hasNext()) {
	            String resultsOfProcessedList = (String)existingElement.next();       
	            bufferedContent.write(resultsOfProcessedList);      
	            bufferedContent.newLine();
	        }

	        bufferedContent.close();
	 }
		
}
