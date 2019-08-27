import java.util.Arrays;

class Hamming {
    String leftStrand = "";
    String rightStrand = "";

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (!leftStrand.matches("^*|[CAGT]*") || !rightStrand.matches("^*|[CAGT]*")) {
            throw new IllegalStateException("leftStrand and rightStrand must be of equal length.");
        }

        if (leftStrand.isEmpty() && rightStrand.length() > 0) {
            throw new IllegalStateException("left strand must not be empty.");
        }

        if (rightStrand.isEmpty() && leftStrand.length() > 0) {
            throw new IllegalStateException("right strand must not be empty.");
        }

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalStateException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        if (leftStrand.equals(rightStrand)) {
            return 0;
        }

        String[] left = leftStrand.split("");
        String[] right = rightStrand.split("");
//        Arrays.sort(left);
//        Arrays.sort(right);
        int count = 0;

        for (int i = 0; i < left.length; i++) {
            if (!left[i].equals(right[i])) {
                ++count;
            }
        }

        return count;
    }
}
