package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> getSymptoms ();
	
	/**
	 * Count the occurrences of a String in a list and map them with their count, then order the list alphabetically.
	 * @return A String List where every unique line in the input is a String mapped to the count of its occurrences
	 */
	ArrayList<String> analyze(List<String> list);
}
