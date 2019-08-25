public final class Hamming {
    private final String leftStrand;
    private final String rightStrand;
    int hammin = 0;

    public Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {

        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand == "") {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand == "") {
                throw new IllegalArgumentException("right strand must not be empty.");
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        } else {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }
  
    public String getLeftStrand() {
        return this.leftStrand;
    }

    public String getRightStrand() {
        return this.rightStrand;
    }
    int gapBetweenTwoChainsDna() {
        hammin = 0;
        int i = 0;
        for (i = 0; i < getLeftStrand().length(); i++) {
            if (getLeftStrand().charAt(i) != getRightStrand().charAt(i)) {
                hammin++;
            };

        }
        return hammin;


    }
    int getHammingDistance() {

        return (getLeftStrand().equals(getRightStrand()) ? 0 : gapBetweenTwoChainsDna());


    }

}