class Hamming {
    //private final Object IllegalArgumentException;
    int distance = 0;
    Hamming(String leftStrand, String rightStrand) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        if (leftStrand.length() == 0 && rightStrand.length() == 0) distance = 0;
        else {
            if (leftStrand.length() == 0) throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand.length() == 0) throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (leftStrand.length() > rightStrand.length() || rightStrand.length() > leftStrand.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        try {
            char[] left = leftStrand.toCharArray();
            char[] right = rightStrand.toCharArray();
            for (int q = 0; q < left.length; q++) {
                if(left[q] != right[q]) distance++;
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }



    }

    int getHammingDistance() {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        return distance;
    }

}
