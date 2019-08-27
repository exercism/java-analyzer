class Hamming{
    private String Strand1, Strand2;
    Hamming(String leftStrand, String rightStrand) {
        this.Strand1 = leftStrand;
        this.Strand2 = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException{
        if(Strand1.isEmpty()){
            throw new IllegalArgumentException("left strand must not be empty.");
        }else if(Strand2.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
        }else if(Strand1.length() != Strand2.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }else{
        int hamDistance = 0;
        for(int i = 0; i < Strand1.length(); i++){
            if(Strand1.charAt(i) != Strand2.charAt(i)) hamDistance++;
        }
        return hamDistance;
        }
    }

}
