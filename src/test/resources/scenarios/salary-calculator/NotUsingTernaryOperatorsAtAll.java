package scenarios.salarycalculator;

public class SalaryCalculator {

    public double salaryMultiplier(int daysSkipped) {
        if (daysSkipped < 5) {
            return 1;
        }

        return 0.85;
    }

    public int bonusMultiplier(int productsSold) {
        if (productsSold < 20) {
            return 10;
        }

        return 13;
    }

    public double bonusForProductsSold (int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary (int daysSkipped, int productsSold) {
        double finalSalary = 1000.0 * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
        
        if (finalSalary > 2000.0) {
            return 2000.0;
        }

        return finalSalary;
    }
}
