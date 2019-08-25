class Hamming{
    String leftStrand;
    String rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.isEmpty() && !(rightStrand.isEmpty())){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(rightStrand.isEmpty() && !(leftStrand.isEmpty())){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length()!=rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand=leftStrand;
        this.rightStrand=rightStrand;
    }
    int getHammingDistance(){
        

        int count=0;
        for(int i=0;i<leftStrand.length();i++){
            if(leftStrand.charAt(i)!=rightStrand.charAt(i)){
                count++;
            }
        }
        return count;
    }

}
