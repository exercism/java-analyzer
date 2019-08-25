import java.util.Optional;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if (leftStrand.length() != rightStrand.length() && (leftStrand.length() == 0 || rightStrand.length() == 0)) {
            String str = leftStrand.length() == 0 ? "left strand" : "right strand";
            throw new IllegalArgumentException(String.format("%s must not be empty.", str));
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

        int distance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                distance++;
        }

        return distance;
    }

}
