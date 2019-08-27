import java.util.ArrayList;

class Hamming {
    private String DNA1;
    private String DNA2;

    public Hamming(String leftStrand, String rightStrand) {
        DNA1 = leftStrand;
        DNA2 = rightStrand;

        if (DNA1.isEmpty() && (DNA2.length() > 0)) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (DNA2.isEmpty() && (DNA1.length() > 0)) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (DNA1.length() != DNA2.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }


    public int getHammingDistance() {
        int listOfDifferences = 0;
        for (int i = 0; i < DNA1.length(); i++) {
            if (DNA1.charAt(i) != DNA2.charAt(i)) {
                listOfDifferences += 1;
            }
        }
        return listOfDifferences;
    }
}
