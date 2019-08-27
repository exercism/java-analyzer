class Hamming {
  private String leftStrand;
  private String rightStrand;
  private int distance;
  private int length;

  Hamming(String leftStrand, String rightStrand) {
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;
    this.distance = 0;
    this.length = leftStrand.length();

    if (this.length != rightStrand.length()) {
      throw new IllegalArgumentException(illegalArgumentExceptionMessage());
    }
  }

  int getHammingDistance() {
    for (int i = 0; i < this.length; i++) {
      if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) this.distance++;
    }
    return this.distance;
  }

  private String illegalArgumentExceptionMessage() {
    if (this.length == 0) return "left strand must not be empty.";
    if (this.rightStrand.length() == 0) return "right strand must not be empty.";
    return "leftStrand and rightStrand must be of equal length.";
  }
}
