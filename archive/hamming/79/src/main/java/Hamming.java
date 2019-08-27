class Hamming {

    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand==""&&rightStrand==""){
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
        else if(leftStrand=="")
            throw new IllegalArgumentException("left strand must not be empty.");
        else if(rightStrand=="")
            throw new IllegalArgumentException("right strand must not be empty.");
        else if(leftStrand.length()!=rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        else{
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }

    int getHammingDistance() {
        int count = 0;
        for(int i=0;i<leftStrand.length();i++){
            if(leftStrand.charAt(i)!=rightStrand.charAt(i))
                count++;
        }
        return count;
    }

}
