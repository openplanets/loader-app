package eu.scape_project.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import eu.scape_project.pt.main.LoaderIO;


/**
 * Test to extract xml files from a zipped folder
 * @author mhn
 *
 */
public class AppLoaderZipTest {
	
	private static String pathToFile; 

	@Before
	public void setup() {
		pathToFile = "/home/mhn/Downloads/onb_mets.zip";	
	}
	
	
	@Test
	public void test() {
		
		LoaderIO io = new LoaderIO(); 
		
		try {
			io.extractZipFile(pathToFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
