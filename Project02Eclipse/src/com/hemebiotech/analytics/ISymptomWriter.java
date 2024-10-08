package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will write symptoms 
 * The implementation does need a map of symptoms
 * 
 */
public interface ISymptomWriter {

	/**
	 * which writes symptoms and quantities in a folder named result.out
	 * @throws IOException 
	 */
	public void writeSymptoms(List<String> elementsOfList) throws IOException;       
	
}
