import java.util.*;
import java.io.*;

public class StudentData {
  
  private ArrayList<String> unformattedData;
  private String[][] formattedData;
  private File fileName;
  
  public StudentData(String file) {
    try {
      fileName = new File(file); //opens the file to read
      Scanner scan = new Scanner(fileName); //instantiates a Scanner object that will read the file
      
      /* Initialize the ArrayList and read through the file, populating the  */
      unformattedData = new ArrayList<String>();
      
      
      
      
      /* populate unformattedData array with data from the table */
      while(scan.hasNextLine() == true){
        scan.nextLine();
    }
      /* use String method replaceAll(String replace, String replacement) to get rid double quotes */
      
      /* parse through the first row of unformattedData to determine the number of columns */
      
      
      
      /* initialize the formattedData array using rows and columns */
      
      
      
      /* populate formattedData array with data from unformattedData */
      
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  public String[][] getFormattedData() {
    return formattedData;
  }
  
  
  /* Returns the row containing the country and year. Returns -1 if not found. */
  public int getRow(String countryName, String year) {
  
    return -1;
  }
}
  
  