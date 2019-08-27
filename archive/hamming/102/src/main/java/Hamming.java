import java.lang.IllegalArgumentException;
class Hamming {
  private String lstrn, rstrn;
    Hamming(String leftStrand, String rightStrand) {
      lstrn = leftStrand;
      rstrn = rightStrand;
       if (lstrn.isEmpty() && !rstrn.isEmpty())
        throw new IllegalArgumentException("left strand must not be empty.");
      else if (rstrn.isEmpty() && !lstrn.isEmpty())
        throw new IllegalArgumentException("right strand must not be empty.");
      else if (lstrn.length() != rstrn.length())
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
      int distance = 0;
      for (int i = 0; i < lstrn.length(); i++){
        if (lstrn.charAt(i) != rstrn.charAt(i)) distance++;
      }
      return distance;
    }

}
