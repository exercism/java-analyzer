import java.util.stream.IntStream;
class Hamming {
  String leftStrand;
  String rightStrand;

  Hamming(String leftStrand, String rightStrand) {
    this.leftStrand = leftStrand;
    this.rightStrand = rightStrand;

    if ((leftStrand.length() == 0 || rightStrand.length() == 0) && (leftStrand.length() != rightStrand.length())) {
      throw new IllegalArgumentException(String.format("%s must not be empty.", (leftStrand.length() == 0) ? "left strand" : "right strand"));
      }
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }
    }

  int getHammingDistance() {
    int diffCount = (int) IntStream.range(0, leftStrand.length())
                    .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                    .count();
    return diffCount;
    }

}
