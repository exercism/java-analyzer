class Hamming {
    private char[] dna_left;
    private char[] dna_right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == null)   throw new IllegalArgumentException("left strand must not be empty.");
        if (rightStrand == null)  throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.equals("") && !rightStrand.equals("")) throw new IllegalArgumentException("left strand must not be empty.");
        if (!leftStrand.equals("") && rightStrand.equals("")) throw new IllegalArgumentException("right strand must not be empty.");
        if (rightStrand.length() != leftStrand.length())  throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        dna_left  = new char[leftStrand.length()];
        dna_left  = leftStrand.toCharArray();
        dna_right = new char[rightStrand.length()];
        dna_right = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int counter = 0;
        for (int i = 0; i < dna_left.length; i++) {
            if (dna_left[i] != dna_right[i]) counter++;
        }
        return counter;
    }

}
