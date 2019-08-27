class Hamming {

    String lStrand;
    String rStrand;
    int lStrandLength;
    int rStrandLength;
    
    Hamming(String leftStrand, String rightStrand) {
        this.lStrand = leftStrand;
        this.rStrand = rightStrand;
        this.lStrandLength = lStrand.length();
        this.rStrandLength = rStrand.length();
        
        if (lStrandLength != rStrandLength){
            
            if (lStrandLength == 0){
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            
            if (rStrandLength == 0){
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        
        
    }

    int getHammingDistance() {
        int a = 0;
        int hammingDistance = 0;
        
        while(a < lStrandLength){
            if(lStrand.charAt(a) != rStrand.charAt(a)){
                hammingDistance++;
            }
            a++;
        }
        
        return hammingDistance;
    }

}
