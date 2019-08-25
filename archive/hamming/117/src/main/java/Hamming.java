class Hamming {
  String leftString;
  String rightString;

  Hamming(String leftStrand, String rightStrand) {
    String leftString = leftStrand;
    String rightString = rightStrand;
  }

  int getHammingDistance() {
    if (leftString.equals(rightString)) {
      return 0;
    } else if (leftString.length() != rightString.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    } else if (leftString.isEmpty()) {
      throw new IllegalArgumentException("left strand must not be empty.");
    } else {
      int hammingDistance = 0;
      for (int i = 0; i < leftString.length(); i++) {
        if (leftString.charAt(i) != rightString.charAt(i)) {
          hammingDistance += 1;
        }
      }
      return hammingDistance;
    }
  }

}
