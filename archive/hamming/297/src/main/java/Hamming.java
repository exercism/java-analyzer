class Hamming {
    String leftStrand, rightStrand;
    int lenLeft, lenRight;
    
    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        lenLeft = leftStrand.length();
        lenRight = rightStrand.length();
        if (lenLeft != lenRight){           
            if(lenLeft == 0) throw new IllegalArgumentException("left strand must not be empty.");
            else if(lenRight == 0) throw new IllegalArgumentException("right strand must not be empty."); 
            else throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length."); 
            
        }
    }

    int getHammingDistance() {
        int dist = 0;
        if(lenLeft != 0){
            for(int i = 0; i < lenLeft  ; i++) { 
                if (rightStrand.charAt(i) != leftStrand.charAt(i)) dist++;
            }
        } 
        return dist; 
    }
}
