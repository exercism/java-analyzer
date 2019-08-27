class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.length() != rightStrand.length()) {
            if(leftStrand == null || "".equals(leftStrand)) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if(rightStrand == null || "".equals(rightStrand)) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

    }

    int getHammingDistance() {
        int count = 0;
           for(int i=0; i< leftStrand.length(); i++) {
                if(leftStrand.charAt(i) != rightStrand.charAt(i)) {
                    count++;
                }
            }

        return count;
    }

}
