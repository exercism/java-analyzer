class Hamming {
    char[] ls;
    char[] rs;

    Hamming(String leftStrand, String rightStrand) {
      ls = leftStrand.toCharArray();
      rs = rightStrand.toCharArray();
      if (ls.length != rs.length) {
        if (leftStrand == ""){
          throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand == ""){
          throw new IllegalArgumentException("right strand must not be empty.");
        }
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      }

    }

    int getHammingDistance() {
      int distance = 0;
      for (int i = 0; i < ls.length; i++){
        if (ls[i] != rs[i]) {
          distance++;
        }
      }
      return distance;
    }

}
