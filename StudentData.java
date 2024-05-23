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
      while(scan.hasNextLine()){
        String s = "";
        s=scan.nextLine();
        s.replaceAll("/","");
        unformattedData.add(s);
    }
    scan.close();
      /* use String method replaceAll(String replace, String replacement) to get rid double quotes */
      /* parse through the first row of unformattedData to determine the number of columns */
      String str  = unformattedData.get(0);
      int count = 0;
      int i = str.indexOf(",");
      while(i !=-1){
        count++;
        str = str.substring(str.indexOf(",")+1);
        i = str.indexOf(",");

      } 
      
      
      
      /* initialize the formattedData array using rows and columns */
      int j = unformattedData.size();
      formattedData = new String[j][count];

      
      /* populate formattedData array with data from unformattedData */
      for(int r =0;r<unformattedData.size();r++)
      {
          int c =1;
          String line =unformattedData.get(r);
          int k =line.indexOf(",");
          formattedData[r][0]=line.substring(0,k);
          line =line.substring(k+1);
          k=line.indexOf(",");
          while(k!=-1)
          {
              formattedData[r][c]=line.substring(0,k);
              c++;
              line=line.substring(k+1);
              k=line.indexOf(",");
          }
          formattedData[r][c]=line;
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

  for(int r =0; r <formattedData.length;r++)
  {
      if((formattedData[r][0].equals(countryName))&&(formattedData[r][1].equals(year)))
          {
              return r;
          }
      }
  
    return -1;
  }
}
  
  