class Hamming {

    private String leftStrand = "";
    private String rightStrand = "";

    Hamming(String leftStrand, String rightStrand) {
       
        if (leftStrand.length() != rightStrand.length()) {

            if (leftStrand.length() == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
    
            if (rightStrand.length() == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        setLeftStrand(leftStrand);
        setRightStrand(rightStrand);
    }

    private void setLeftStrand(String leftString) {
        this.leftStrand = leftString;
    }

    private void setRightStrand(String rightStrand) {
        this.rightStrand = rightStrand;
    }


    int getHammingDistance() {
        int distance = 0;

        for (int i = 0; i < leftStrand.length(); i++) {
            if (isCellDifferent(i)) 
                distance++;
            
        }
        return distance;
    }

    private boolean isCellDifferent(int i) {
        if (!leftStrand.substring(i, (i+1)).equals(rightStrand.substring(i, (i+1)))) 
            return true;
        else 
            return false;
        
    }

}
