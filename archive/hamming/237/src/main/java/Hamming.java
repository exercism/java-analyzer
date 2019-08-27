class Hamming {

    char[] leftString, rightString;
    
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length()==0 && rightStrand.length() >0 ){
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (leftStrand.length()>0 && rightStrand.length() ==0 ){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftString = leftStrand.toCharArray();
        this.rightString = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int distance = 0;

        if (this.leftString.length == 0){
            return distance;
        }

        for(int i = 0; i < this.leftString.length; i ++){
            if (this.leftString[i]!=this.rightString[i]){
                distance += 1;
            }
        }
        return distance;
    }

}
