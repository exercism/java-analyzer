class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        String error = "leftStrand and rightStrand must be of equal length.";
        if(leftStrand.length() != rightStrand.length()) {
            if(leftStrand.length()==0)
                error = "left strand must not be empty.";
            else if(rightStrand.length()==0)
                error = "right strand must not be empty.";
            throw new IllegalArgumentException(error);
        } else
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for(int i = 0; i < leftStrand.length(); i++){
            distance = leftStrand.charAt(i) == rightStrand.charAt(i) ? distance : (distance+1); //Ternary operations seem to dislike int++?
        }
        return distance;
    }

}
