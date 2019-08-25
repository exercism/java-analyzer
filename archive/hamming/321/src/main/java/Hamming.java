class Hamming {

  private int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {
      if(leftStrand.length() != rightStrand.length()) {
        if(leftStrand.isEmpty()) {
          throw new IllegalArgumentException("left strand must not be empty.");
        }
        else if(rightStrand.isEmpty()) {
          throw new IllegalArgumentException("right strand must not be empty.");
        }
        else {
          throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
      }
      else {
        for(int i = 0; i<leftStrand.length(); i++) {
          if(leftStrand.charAt(i) != rightStrand.charAt(i)) {
            hammingDistance = hammingDistance + 1;
          }
        }
      }
    }

    int getHammingDistance() {
      return hammingDistance;
    }

}
