class Hamming {
   private String leftStrand;
   private String rightStrand;
    //private int hammingDistance=0;
    Hamming(String leftStrand,String rightStrand) {
        if(leftStrand.length()!=rightStrand.length()) {
            if (leftStrand == null || leftStrand == "")
                throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand == null || rightStrand == "")
                throw new IllegalArgumentException("right strand must not be empty.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
            this.leftStrand=leftStrand;
        this.rightStrand=rightStrand;
    }
    int getHammingDistance() {
     int hammingdistance=0;
    if (leftStrand.equals(rightStrand)) {
        return hammingdistance;
      }
    else
    {
        for (int i = 0; i <leftStrand.length() ; i++) {
            if(leftStrand.charAt(i)!=rightStrand.charAt(i))
                hammingdistance++;
        }
    }
      return hammingdistance;
    }
}
