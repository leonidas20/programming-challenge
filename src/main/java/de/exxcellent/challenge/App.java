package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
    	//1st commit
    	//2nd commit
    	//3rd commit
    	
    	 String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …

      String csvFile = "./src/main/resources//de/exxcellent/challenge//weather.csv";

    	String line = "";
    	int lineNumber = 1;
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
                column1 = Integer.valueOf(columns[1]);
                column2 = Integer.valueOf(columns[2]);
                currentDay = columns[0];
            	difference = column1 - column2;
                
                System.out.println("LineNumber:  "+lineNumber +"  maxTemp  " + column1 +"  minTemp  "+ column2 + "  Difference  "+ difference +
                		"  Current Day  " + currentDay + "  finalDifference  " + finalDifference);
                
                if (lineNumber == 1) {
                	finalDifference = difference;
                	dayWithSmallestTempSpread =  currentDay;
                	System.out.println("finalDifference" + finalDifference);
                } else {
                	
                	if (difference < finalDifference ) {
                    	finalDifference = difference;
                    	dayWithSmallestTempSpread =  currentDay;
                	}
                }
                
                lineNumber++;
                
          		}
                catch (NumberFormatException ex) {
                	ex.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
       
        System.out.printf("Day with smallest temperature spread : Day %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        
    }
}
