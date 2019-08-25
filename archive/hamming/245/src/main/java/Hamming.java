class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        validateInput(leftStrand,rightStrand);

    }

    private void validateInput(String leftStrand, String rightStrand) {
        if(leftStrand.isEmpty() &&  !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if(!leftStrand.isEmpty() && rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if(leftStrand.length()   != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {

        int count = 0;

        for (int i =0;i<leftStrand.length();i++) {

            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                count += 1;
            }
        }
        return count;

    }

}
