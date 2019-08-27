import java.util.stream.IntStream;

class Hamming {

    Hamming(String leftStrand, String rightStrand) {
      boolean b;
      // Two remarks:
      //  1. In a version of this code that I was going to send, there were `==` instead of `equals`.
      //    Maybe you should test for this (for instance, with `new Hamming("", new String(""))`).
      //  2. What is the point of treating the case (empty-string, not-empty-string) specially?
      //    This is a particular case of strings of different lengths.
      //    Is that an awkward exercise in exceptions (more precisely, conditionals)?
      //    There are more natural settings for this task.
      if ((b = leftStrand.equals("")) ^ rightStrand.equals(""))
        throw new IllegalArgumentException(String.format("%s strand must not be empty.", b ? "left" : "right"));
      if (leftStrand.length() != rightStrand.length())
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
      this.leftStrand = leftStrand;
      this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
      // I figured this will be faster than the map-reduce one (commented out below)...
      return IntStream.range(0,leftStrand.length())
                .reduce(0, (z,i) -> z + (leftStrand.charAt(i)!=rightStrand.charAt(i) ? 1 : 0));

/*        ... but maybe I'm wrong and the compiler can perform such kinds of optimization.
          Does anybody know?
      return IntStream.range(0,leftStrand.length())
                .map(i -> leftStrand.charAt(i)!=rightStrand.charAt(i) ? 1 : 0)
                .sum();
/**/
    }
    
    String leftStrand, rightStrand;
    
}
