public class CountryData {
    private String name;
    private int year;
    private int population;
    private int[] incomeDeciles;
    public CountryData(StudentData incomeData, String country, String year) {
        name = country;
        this.year = Integer.parseInt(year);
        
    }
    public void setYear(int y){
        year = y;
    }
    public int getYear(){
        return year;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setPopulation(int p){
        population = p;
    }
    public int getPopulation(){
        return population;
    }

    public int totalIncome(){
        int count = 0;
        for(int i = 0; i<incomeDeciles.length; i++){
            count+=incomeDeciles[i];
        }
        return count;
    }

    public double giniIndex(){
        double count = 0;
        for(int i)

        
    }

    
}
