import java.lang.IllegalArgumentException;

class Hamming {
    final private String leftStrand;
    final private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
      int lLen = leftStrand.length();
      int rLen = rightStrand.length();
      if (lLen == 0 && rLen > 0) {
        throw new IllegalArgumentException("left strand must not be empty.");
      }
      if (rLen == 0 && lLen > 0) {
        throw new IllegalArgumentException("right strand must not be empty.");
      }
      if (lLen != rLen) {
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }

      this.leftStrand = leftStrand;
      this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
      int distance = 0;
      for (int i = 0; i < leftStrand.length(); i++) {
        if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
          distance++;
        }
      }
      return distance;
    }
}
