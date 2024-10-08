package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AnalyticsCounter {        
	
	
	public static void main(String args[]) throws Exception {         
		
		ISymptomReader symptomReader = new ReadSymptomDataFromFile();       
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
		
		try
		{
			/**
			 * Get list of symptoms
			 */
			List<String> symptomsList= symptomReader.getSymptoms("symptoms.txt");

			/**
			 * Count symptoms and organize them alphabetically
			 */
			symptomsList = symptomReader.analyze(symptomsList);

			/**
			 * Output Symptoms list
			 */
			symptomWriter.writeSymptoms(symptomsList);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
