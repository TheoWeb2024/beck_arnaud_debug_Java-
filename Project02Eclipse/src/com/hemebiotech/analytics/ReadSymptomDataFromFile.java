package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	
	public ReadSymptomDataFromFile () { 
		
	}
	
	@Override
	/**
	 *  get symptoms from file 
	 */
	public List<String> getSymptoms(String filepath) 
	{
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * @param list: A list of Strings containing the symptoms one by per line
	 * itemOfList : it's one element of the list of symptoms
	 */
	@Override
	/**
	 *  analyze data coming from the list 
	 */
	public ArrayList<String> analyze(List<String> list)        
	{
		TreeMap<String, Integer> result = new TreeMap<>();      

		for (String itemOfList : list)
		{
			itemOfList = itemOfList.toLowerCase();
			if (result.containsKey(itemOfList))
			 /**
			  * helps us to add one occurrence more and more until completed
			  */
				result.put(itemOfList, result.get(itemOfList) + 1);        
			else
			{
			 /**
			  * answer when there is only one occurrence for a symptom
			  */
				result.put(itemOfList, 1);                                
			}
		}

		ArrayList<String> listWithCount = new ArrayList<>();
		 /**
		  * allows to ordinate by alphabetic order
		  */
		for (Map.Entry mapElements : result.entrySet())                   
		{
			listWithCount.add(mapElements.getKey() + " = " + mapElements.getValue());     
		}
		return listWithCount;
	}


}
