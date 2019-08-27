class Hamming {

    int ham = 0;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == rightStrand.length()) {
            char[] left = leftStrand.toCharArray();
            char[] right = rightStrand.toCharArray();
            
            for (int i = 0; i < left.length; i++) {
                if (left[i] != right[i]) {
                    ham++;
                }
            }
        } else if (leftStrand.length() == 0 && rightStrand.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (leftStrand.length() != 0 && rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return ham;
    }

}
