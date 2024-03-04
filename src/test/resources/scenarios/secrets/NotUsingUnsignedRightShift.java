package scenarios.secrets;

public class Secrets {
    public static int shiftBack(int value, int amount) {
        return (value >> amount) & ~(Integer.MIN_VALUE >> (amount - 1));
    }

    public static int setBits(int value, int mask) {
        return value | mask;
    }

    public static int flipBits(int value, int mask) {
        return value ^ mask;
    }

    public static int clearBits(int value, int mask) {
        return value & ~mask;
    }
}
