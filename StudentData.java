import java.util.*;
import java.io.*;

public class StudentData {
  
  private ArrayList<String> unformattedData;
  private String[][] formattedData;
  private File fileName;
  
  public StudentData(String file) {
    try {
      fileName = new File(file); 
      Scanner scan = new Scanner(fileName); 
      
      /* Initialize the ArrayList and read through the file, populating the  */
      unformattedData = new ArrayList<String>();
      
      /* populate unformattedData array with data from the table */
      while(scan.hasNextLine()){
        String s = scan.nextLine();
        s = s.replaceAll("\"", ""); 
        unformattedData.add(s);
      }
      scan.close();
      
      /* parse through the first row of unformattedData to determine the number of columns */
      String str = unformattedData.get(0);
      int count = 1; 
      for (char c : str.toCharArray()) {
        if (c == ',') {
          count++;
        }
      }
      
      /* initialize the formattedData array using rows and columns */
      int numRows = unformattedData.size();
      formattedData = new String[numRows][count];
      
      /* populate formattedData array with data from unformattedData */
      for(int r = 0; r < numRows; r++) {
        String[] l = unformattedData.get(r).split(",");
        for(int c = 0; c < count; c++) {
          formattedData[r][c] = l[c];
        }
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  public String[][] getFormattedData() {
    return formattedData;
  }
  
  /* Returns the row containing the country and year. Returns -1 if not found. */
  public int getRow(String countryName, String year) {
    for(int r = 0; r < formattedData.length; r++) {
      if (formattedData[r][0].equals(countryName) && formattedData[r][1].equals(year)) {
        return r;
      }
    }
    return -1;
  }
}
