class Hamming {

    final int distance;
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && rightStrand.isEmpty()) distance = 0;
        else if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
        else if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
        else if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        else {
            int d = 0;
            for (int i = 0; i < leftStrand.length(); i++) {
                if (leftStrand.charAt(i) != rightStrand.charAt(i)) d++;
            }
            distance = d;
        }
    }

    int getHammingDistance() {
        return distance;
    }

}
