class Hamming {

    private String[] leftStrand;
    private String[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.equals("") && !rightStrand.equals("")){
            throw new IllegalArgumentException("left strand must not be empty.");
        }else{
            this.leftStrand = leftStrand.toUpperCase().split("");
        }
        if(rightStrand.equals("") && !leftStrand.equals("")){
            throw new IllegalArgumentException("right strand must not be empty.");
        }else{
            this.rightStrand = rightStrand.toUpperCase().split("");
        }
        if(leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int result = 0;
        for(int protein=0; protein<leftStrand.length; protein++){
            if(!leftStrand[protein].equals(rightStrand[protein])){
                result++;
            }
        }
        return result;
    }
}
