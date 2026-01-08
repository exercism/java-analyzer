
public class CarsAssemble {

    private final int defaultProductionRate = 221;

    public double productionRatePerHour(int speed) {
        double rate = null;

        if (speed == 10) {
            rate = 0.77;
        }else if (speed == 9) {
            rate = 0.8;
        } else if (speed >= 5) {
            rate = 0.9;
        } else {
            rate = 1.0;
        }

        return defaultProductionRate * speed * rate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }

}
