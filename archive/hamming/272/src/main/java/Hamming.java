class Hamming {
    private String lStand,rStrand;
    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length()==rightStrand.length()){
            lStand=leftStrand;
            rStrand=rightStrand;
        }else if(leftStrand.length()==0){
            throw new IllegalArgumentException("left strand must not be empty.");
        }else if(rightStrand.length()==0){
            throw new IllegalArgumentException("right strand must not be empty.");
        }else{
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int out=0;
        for(int i=0;i<lStand.length(); i++){
            if(lStand.charAt(i)!=rStrand.charAt(i)){
                out++;
            }
        }
        return out;
    }

}
