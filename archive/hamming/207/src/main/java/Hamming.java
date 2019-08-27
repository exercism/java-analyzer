package main.java;

public class Hamming {
    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        this.validate(leftStrand, rightStrand);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int count = 0;

        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private void validate(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) {
            return;
        }

        if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

}
