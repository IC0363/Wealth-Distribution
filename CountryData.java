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
        if(incomeDeciles[0] !=-1){
        int count = 0;
        for(int i = 0; i<incomeDeciles.length; i++){
            count+=incomeDeciles[i];
        }
        return count;
    } 
    return 0;
        
    }

    public double giniIndex(){
        if(incomeDeciles[0]!=-1){
            int g = incomeDeciles[0]+2*(incomeDeciles[0] + incomeDeciles[1]);
            for(int i = 2; incomeDeciles.length-1;i++){

            }

        
    
}

    
}
