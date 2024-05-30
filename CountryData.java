public class CountryData {
    private String name;
    private int year;
    private int population;
    private int[] incomeDeciles;
    
    public CountryData(StudentData incomeData, String country, String year) {
        this.name = country;
        this.year = Integer.parseInt(year);
        
        int row = incomeData.getRow(country, year);
        if (row != -1) {
            String[] rowData = incomeData.getFormattedData()[row];
            incomeDeciles = new int[rowData.length - 2];
            for (int i = 2; i < rowData.length; i++) {
                incomeDeciles[i - 2] = Integer.parseInt(rowData[i]);
            }
        } else {
            incomeDeciles = new int[0]; 
        }
    }
    
    public void setYear(int y) {
        year = y;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPopulation(int p) {
        population = p;
    }
    
    public int getPopulation() {
        return population;
    }
    
    public int[] getIncomeDeciles() {
        return incomeDeciles;
    }
    
    public void setIncomeDeciles(int[] iD) {
        incomeDeciles = iD;
    }
    
    public int totalIncome() {
        if (incomeDeciles.length > 0) {
            int count = 0;
            for (int income : incomeDeciles) {
                count += income;
            }
            return count;
        }
        return 0;
    }

    public double giniIndex() {
        if (incomeDeciles.length > 0) {
            int g = incomeDeciles[0] + 2 * (incomeDeciles[0] + incomeDeciles[1]);
            for (int i = 2; i < incomeDeciles.length - 1; i++) {
                g += 2 * (g + incomeDeciles[i]);
            }
            g += incomeDeciles[incomeDeciles.length - 1];
            return((double)1.0- (0.1 / totalIncome())  *g) ;
        }
        return 0;
    }
}