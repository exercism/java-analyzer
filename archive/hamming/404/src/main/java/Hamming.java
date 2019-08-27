class Hamming {

  private String leftStrand;
  private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

      if (rightStrand.length() != leftStrand.length()) {

        if (leftStrand == "" && rightStrand != "") {
          throw new IllegalArgumentException("left strand must not be empty.");
        } else if (leftStrand != "" && rightStrand == "") {
          throw new IllegalArgumentException("right strand must not be empty.");
        }

        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {

      int hammingDis = 0;

        for (int i = 0; i < this.rightStrand.length(); i++) {
          if (this.rightStrand.charAt(i) != this.leftStrand.charAt(i)) {
            hammingDis++;
          }
        }

        return hammingDis;
    }

}
