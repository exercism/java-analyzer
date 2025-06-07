public class CarsAssemble {

    private final int defaultProductionRate = 221;

    public double productionRatePerHour(int speed) {
        return defaultProductionRate * speed * successRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    private double successRate(int speed) {
        
        if (speed == 10) {
            return 0.77;
        } else if (speed == 9) {
            return 0.8;
        } else if (speed >= 5) {
            return 0.9;
        } else {
            return 1.0;
        }
        
    }
}
