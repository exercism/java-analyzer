class Hamming {
    
    String left = "";
    String right = "";

    Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;
        
        try {
            getHammingDistance();
        }
        catch(UnsupportedOperationException txt){
        }
    }
    
    int getHammingDistance() {
        int total = 0;
        
        if(left.length() != right.length()){
            if(right.equals("")){
                throw new IllegalArgumentException("right strand must not be empty.");
        }
            if(left.equals("")){
                throw new IllegalArgumentException("left strand must not be empty.");
        }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        
        for(int i = 0; i < left.length(); i++){
            if (left.charAt(i) != right.charAt(i))
                total++;
        }
        return total;
    }
}