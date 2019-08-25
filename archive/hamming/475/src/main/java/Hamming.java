class Hamming {
    
    private String leftStrand, rightStrand;

    Hamming(String leftStrand, String rightStrand) {
      this.leftStrand = leftStrand;
      this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
      int differences = 0;
      
      for (int i=1; i < leftStrand.length(); i++)
        if (leftStrand.charAt(i) != rightStrand.charAt(i))
          differences++;
  
      return differences;
    }

}
