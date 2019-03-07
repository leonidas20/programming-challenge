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
    	

    	
        // In the corner case that 2 days have the same difference of temperature, the program will print the first day with the smallest
        // difference of temperature
    	CSVparser objCalculateTemperature = new CSVparser("weather.csv");
    	
        System.out.printf("Day with smallest temperature spread : Day %s%n", objCalculateTemperature.calculateColumns());

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        
        
      //  System.out.println(objCalculateTemperature.calculateColumns());
        
    }
}
