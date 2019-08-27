class Hamming {
    public String firstStrand;
    public String secondStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() ==  rightStrand.length()){
            firstStrand = leftStrand;
            secondStrand = rightStrand;
        }else if (leftStrand.length() == 0){
            throw new IllegalArgumentException("left strand must not be empty.");
        }else if (rightStrand.length() == 0){
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < firstStrand.length(); i++){
            count = firstStrand.charAt(i) != secondStrand.charAt(i) ? count + 1 : count;
        }
        return count;
    }

}
