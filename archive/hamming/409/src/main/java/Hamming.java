import java.util.stream.IntStream;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        checkStrands(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) return 0;

        String[] leftStrandArray = leftStrand.split("");
        String[] rightStrandArray = rightStrand.split("");

        return countDifferences(leftStrandArray, rightStrandArray);
    }

    private int countDifferences(String[] leftStrandArray, String[] rightStrandArray) {
        Long differencesCount = IntStream.range(0, leftStrandArray.length)
                .filter(i -> !rightStrandArray[i].equals(leftStrandArray[i])).count();

        return differencesCount.intValue();
    }

    private void checkStrands(String leftStrand, String rightStrand) {
        if (strandsWereFilled(leftStrand, rightStrand) && !strandsHaveEqualsLength(leftStrand, rightStrand)) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
    }

    private boolean strandsHaveEqualsLength(String leftStrand, String rightStrand) {
        return leftStrand.length() == rightStrand.length();
    }

    private boolean strandsWereFilled(String leftStrand, String rightStrand) {
        return !leftStrand.isEmpty() && !rightStrand.isEmpty();
    }

}
