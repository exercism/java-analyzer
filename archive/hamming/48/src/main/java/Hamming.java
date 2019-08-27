class Hamming {
String lStrand, rStrand;

    Hamming(String leftStrand, String rightStrand) {
        
        if(leftStrand.isEmpty() && !rightStrand.isEmpty()){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(rightStrand.isEmpty() && !leftStrand.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.lStrand = leftStrand;
        this.rStrand = rightStrand;
        
    }

    int getHammingDistance() {
        int count = 0;
        
        for(int i=0; i < lStrand.length(); i++){
            if(lStrand.charAt(i) != rStrand.charAt(i))
                count++;
        }
        
        return count;
    }

}
