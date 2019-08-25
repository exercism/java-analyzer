import java.util.stream.IntStream;

class Hamming {

  String leftStrand;
  String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
      this.leftStrand = leftStrand;
      this.rightStrand = rightStrand;

      // Solution only expected to work on stands of identical length
      if (leftStrand.length() != rightStrand.length()) {
          if (leftStrand.length() == 0)
              throw new IllegalArgumentException("left strand must not be empty.");

          if (rightStrand.length() == 0)
              throw new IllegalArgumentException("right strand must not be empty.");

          throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }

}

    int getHammingDistance() {
      if (leftStrand.isEmpty() && rightStrand.isEmpty())
          return 0;

      int count = 0;
      for (int i = 0; i < leftStrand.length(); i++) {
          if (leftStrand.charAt(i) != rightStrand.charAt(i))
              count++;
      }

      return count;
    } 

}
