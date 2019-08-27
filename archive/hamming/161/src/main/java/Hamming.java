class Hamming {
    private char[] leftStrand;
    private char[] rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length() && (leftStrand.isEmpty() || rightStrand.isEmpty())) {
            String exceptionMessage = leftStrand.length()<rightStrand.length()? "left" : "right";
            exceptionMessage += " strand must not be empty.";

            throw new IllegalArgumentException(exceptionMessage);
        }

        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();

    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0;i<leftStrand.length;i++){
            if(leftStrand[i] != rightStrand[i]) distance++;
        }
        return distance;
    }


}
