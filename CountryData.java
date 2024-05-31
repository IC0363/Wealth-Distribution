public class CountryData {
    private String name;
    private int year;
    private int[] incomeDeciles;

    public CountryData(StudentData incomeData, String country, String year) {
        this.name = country;
        try {
            this.year = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            this.year = -1;
        }

        int row = incomeData.getRow(country, String.valueOf(this.year));
        if (row != -1) {
            String[] rowData = incomeData.getFormattedData()[row];
            incomeDeciles = new int[10];
            for (int i = 2; i < 12; i++) {
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

    public int[] getIncomeDeciles() {
        return incomeDeciles;
    }

    public void setIncomeDeciles(int[] iD) {
        incomeDeciles = iD;
    }

    public int totalIncome() {
        int count = 0;
        for (int income : incomeDeciles) {
            count += income;
        }
        return count;
    }

    public double giniIndex() {
        if (incomeDeciles.length > 0) {
            int income = 0;
            int sum = 0;
            for (int i = 0; i < incomeDeciles.length; i++) {
                income += incomeDeciles[i];
                if (i == 0 || i == incomeDeciles.length - 1) {
                    sum += income;
                } 
                else {
                    sum += 2 * income;
                }
            }
            return 1 - ((double) 0.1 / totalIncome()) * sum;
        }
        return 0;
    }
}
