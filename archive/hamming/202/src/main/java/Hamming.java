class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) { //Constructor for a hamming
        //******************************************************
        //Throws exception if the strings are not the same length
        //Throws exceptions if the left or right strand are empty
        //******************************************************
        if(leftStrand.length()!=rightStrand.length()){
            if(leftStrand==""){
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            else if(rightStrand==""){
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }


    int getHammingDistance() {
        int hamming= 0;
       //Increments through both strands at the same time to compare characters at particular index value
        for(int i =0; i<=leftStrand.length()-1;i++){
            if(leftStrand.charAt(i)!=rightStrand.charAt(i)){
                hamming++;
            }
        }
        return hamming;
    }

}
