class Hamming {

  private String leftStrand;
  private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
      if ( leftStrand == "" && rightStrand == "" ) {
        // all good
      } else if ( leftStrand == "" ) {
        throw new IllegalArgumentException("left strand must not be empty.");
      } else if ( rightStrand == "" ) {
        throw new IllegalArgumentException("right strand must not be empty.");
      } else if (!( leftStrand.length() == rightStrand.length() )) {
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }

      this.leftStrand = leftStrand;
      this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
      int distance = 0;
      int index = 0;

      for(char c : this.leftStrand.toCharArray()) {
          if ( !(c == this.rightStrand.toCharArray()[index]) ) {
            distance++;
          }
          index++;
      }
      return distance;
    }

}
