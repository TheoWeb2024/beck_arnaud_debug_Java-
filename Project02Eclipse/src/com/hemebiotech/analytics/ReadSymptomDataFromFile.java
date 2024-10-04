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

	
	public ReadSymptomDataFromFile () { // default constructor 
		
	}
	
	@Override
	public List<String> getSymptoms(String filepath) {
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
	 */
	@Override
	public ArrayList<String> analyze(List<String> list)
	{
		TreeMap<String, Integer> result = new TreeMap<>();

		for (String l : list)
		{
			l = l.toLowerCase();
			if (result.containsKey(l))
				result.put(l, result.get(l) + 1);
			else
			{
				result.put(l, 1);
			}
		}

		ArrayList<String> listWithCount = new ArrayList<>();
		for (Map.Entry m : result.entrySet())
		{
			listWithCount.add(m.getKey() + " = " + m.getValue());
		}
		return listWithCount;
	}


}
