import java.util.concurrent.atomic.AtomicInteger;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        setLeftStrand(leftStrand);
        setRightStrand(rightStrand);
    }

    int getHammingDistance() {
        AtomicInteger distance = new AtomicInteger();
        for (int i = 0; i < getLeftStrand().length(); i++) {
            if (getLeftStrand().charAt(i) != getRightStrand().charAt(i)) {
                distance.getAndIncrement();
            }
        }
        return distance.get();
    }

    private String getLeftStrand() {
        return leftStrand;
    }

    private void setLeftStrand(String leftStrand) {
        this.leftStrand = leftStrand;
    }

    private String getRightStrand() {
        return rightStrand;
    }

    private void setRightStrand(String rightStrand) {
        this.rightStrand = rightStrand;
    }
}