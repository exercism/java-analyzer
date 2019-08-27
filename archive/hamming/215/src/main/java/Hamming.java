class Hamming {
private String leftStrand;
private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if(this.rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (this.leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
       getHammingDistance();
    }

    int getHammingDistance() {
        int hamDist = 0;
        for (int i=0; i<leftStrand.length(); i++ ) {
            if(leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hamDist+=1;
            }
        }
        return hamDist;
    }

}
