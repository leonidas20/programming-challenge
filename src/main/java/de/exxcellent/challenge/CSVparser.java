package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVparser {
	
	String nameOftheCSVfile;
	String fullRelativePath;
	
	
	
	public CSVparser(String nameOftheCSVfile) {
		this.nameOftheCSVfile = nameOftheCSVfile;
		this.fullRelativePath = "./src/main/resources//de/exxcellent/challenge//"+nameOftheCSVfile;
	}


	public String calculateColumns(int col1, int col2) {
		
		   String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …

		    	String line = "";
		    	int lineNumber = 0;
		        final String cvsSplitBy = ",";

		        try (BufferedReader br = new BufferedReader(new FileReader(fullRelativePath))) {

		      		int difference = -5000;
		      		int finalDifference = 0;
		      		String currentDay = "Unitialized";
		      		
		            while ((line = br.readLine()) != null) {

		                // use comma as delimiter
		                String[] columns = line.split(cvsSplitBy);
		            
		                int column1 = -10000;
		           		int column2 = -1000;
		  
		          		try {
		                column1 = Integer.valueOf(columns[col1]);
		                column2 = Integer.valueOf(columns[col2]);
		                currentDay = columns[0];
		            	difference = Math.abs(column1 - column2);
		                
		                System.out.println("LineNumber:  "+lineNumber +"  col1Value  " + column1 +"  col2Value  "+ column2 + "  Difference  "+ difference +
		                		"  Current Day  " + currentDay + "  finalDifference  " + finalDifference);
		                
		                if (lineNumber == 1) {
		                	finalDifference = difference;
		                	dayWithSmallestTempSpread =  currentDay;
		                } else {
		                	
		                	if (difference < finalDifference ) {
		                    	finalDifference = difference;
		                    	dayWithSmallestTempSpread =  currentDay;
		                	}
		                }
		                
		                lineNumber++;
		                
		          		}
		                catch (NumberFormatException ex) {
		                	System.out.println("The line  " +lineNumber +"  could not be taken into consideration for the requested calculation ");
			                lineNumber++;
		                	ex.printStackTrace();
		                }
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		
		return dayWithSmallestTempSpread;
		
	}
}
