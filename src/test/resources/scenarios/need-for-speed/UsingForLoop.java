package scenarios.neeedforspeed;

public class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distance = 0;
    private int battery = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public boolean batteryDrained() {
        return battery < batteryDrain;
    }

    public int distanceDriven() {
        return distance;
    }

    public int getSpeed() {
        return speed;
    }

    public void drive() {
        if (!batteryDrained()) {
            battery -= batteryDrain;
            distance += speed;
        }
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        for (int i = 0; i < this.distance / car.getSpeed(); i++) {
            car.drive();
        }

        if (car.distanceDriven() >= distance) {
            return true;
        } else
            return false;
    }
}
