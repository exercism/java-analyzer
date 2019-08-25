class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");

        if (!leftStrand.isEmpty() && rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        String[] left = leftStrand.split("");
        String[] right = rightStrand.split("");

        int distance = 0;
        if (left.length == right.length) {
            for (int i = 0; i < left.length; i++) {
                if (! left[i].equals(right[i]))
                    distance++;
            }
        }

        return distance;
    }

}
