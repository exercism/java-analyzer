class Hamming {
    private char[] left;
    private char[] right;

    Hamming(String leftStrand, String rightStrand) {
        if(rightStrand.length() == leftStrand.length()) {
            this.left = leftStrand.toCharArray();
            this.right = rightStrand.toCharArray();
        }
        else if(leftStrand.length() == 0)
            throw new IllegalArgumentException("left strand must not be empty.");
        else if(rightStrand.length() == 0)
            throw new IllegalArgumentException("right strand must not be empty.");
        else
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        int hammingDifference = 0;

        for(int i = 0; i < this.left.length; i++)
            if(this.left[i] != this.right[i])
                hammingDifference++;

        return hammingDifference;
    }

}
