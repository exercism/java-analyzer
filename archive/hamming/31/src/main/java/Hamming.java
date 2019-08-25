
class Hamming {
  private String leftStrand;
  private String rightStrand;

  Hamming(String leftStrand, String rightStrand) {

    if (leftStrand.length() != rightStrand.length()) {
      if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
      if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;

  }


  int getHammingDistance() {
    if (leftStrand.isEmpty() && rightStrand.isEmpty()) return 0;
    char[] DNAs = leftStrand.toCharArray();
    int dna_length = DNAs.length;
    int diff = 0;

    for (int i = 0; i < dna_length; i++) {
      if (DNAs[i] != rightStrand.charAt(i)) {
        diff++;
      }
    }

    return diff;
  }

}
