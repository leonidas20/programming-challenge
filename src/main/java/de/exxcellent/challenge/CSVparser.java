package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVparser {
	
	String nameOftheCSVfile;
	
	
	
	public CSVparser(String nameOftheCSVfile) {
		this.nameOftheCSVfile = nameOftheCSVfile;
	}


	public int calculateColumns(int col1, int col2) {
		
		   String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …

		     //String csvFile = "./src/main/resources//de/exxcellent/challenge//weather.csv";
		     String csvFile = "./src/main/resources//de/exxcellent/challenge//"+nameOftheCSVfile;

		   
		   
		    	String line = "";
		    	int lineNumber = 0;
		        String cvsSplitBy = ",";

		        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

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
		            	difference = column1 - column2;
		                
		                System.out.println("LineNumber:  "+lineNumber +"  maxTemp  " + column1 +"  minTemp  "+ column2 + "  Difference  "+ difference +
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
		                	System.out.println("The line" +lineNumber +"could not be taken into consideration for the requested calculation ");
			                lineNumber++;
		                	ex.printStackTrace();
		                }
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		
		
		
		
		
		
		return Integer.valueOf(dayWithSmallestTempSpread);
		
		
	}
	

}
