class Hamming {
    String leftStrand;
    String rightStrand;
    int HammondLength;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.equals("") && !rightStrand.equals("")){
          throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(rightStrand.equals("") && !leftStrand.equals("")){
          throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(leftStrand.length() != rightStrand.length()){
          throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.HammondLength = leftStrand.length();
    }

    int getHammingDistance() {
        int total = 0;
        for(int i = 0; i < HammondLength; i++){
          if(leftStrand.charAt(i) != rightStrand.charAt(i)){
            total++;
          }
        }
        return total;
    }

}
