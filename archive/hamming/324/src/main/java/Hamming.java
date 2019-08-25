class Hamming {
    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        if(leftStrand.length() == 0 && rightStrand.length() > 0)
            throw new IllegalArgumentException("left strand must not be empty.");

        if(leftStrand.length() > 0 && rightStrand.length() == 0)
            throw new IllegalArgumentException("right strand must not be empty.");

        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int dist = 0;
        for(int i=0; i<leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) dist++;
        }
        return dist;
    }
}
