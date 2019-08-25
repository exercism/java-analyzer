class Hamming {

  private final String left;
  private final String right;

  Hamming(String leftStrand, String rightStrand) {
    if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
      throw new IllegalArgumentException("left strand must not be empty.");
    }
    if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
      throw new IllegalArgumentException("right strand must not be empty.");
    }
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    this.left = leftStrand;
    this.right = rightStrand;
  }

  int getHammingDistance() {

    int dist = 0;

    for (int i = 0; i < left.length(); i++) {
      Character l = left.charAt(i);
      Character r = right.charAt(i);

      if (!l.equals(r)) {
        dist++;
      }
    }

    return dist;
  }

}
