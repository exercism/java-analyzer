import java.util.stream.IntStream;

class Hamming {
  private final String left, right;

  Hamming(String leftStrand, String rightStrand) {
    if (leftStrand.length() == 0 && rightStrand.length() != 0) {
      throw new IllegalArgumentException("left strand must not be empty.");
    }

    if (rightStrand.length() == 0 && leftStrand.length() != 0) {
      throw new IllegalArgumentException("right strand must not be empty.");
    }

    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    left = leftStrand;
    right = rightStrand;
  }

  int getHammingDistance() {
    return IntStream.range(0, right.length())
        .reduce(0, (acc, i) -> acc + (left.charAt(i) != right.charAt(i) ? 1 : 0));
  }
}
