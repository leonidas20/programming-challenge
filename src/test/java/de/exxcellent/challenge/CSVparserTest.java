package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;



public class CSVparserTest {
	
	private String successLabel = "not successful";
	
	
    @BeforeEach
    public void setUp() {
        successLabel = "successful";
        CSVparser newCSVparser = new CSVparser("weather.csv");
    }
    
    
    public void aSetUpPath() {
    	CSVparser newCSVparser = new CSVparser("weather.csv");
        assertNotEquals(newCSVparser.fullRelativePath, "weather.csv");
        
    }
    
    @Test
    public void bSetUpPath() {
    	CSVparser newCSVparser = new CSVparser("weather.csv");
        assertEquals(newCSVparser.fullRelativePath, "./src/main/resources//de/exxcellent/challenge//weather.csv");
    }
    
    
    
	

}
