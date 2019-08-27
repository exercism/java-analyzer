import java.util.Optional;
import java.util.stream.IntStream;
import java.util.function.IntPredicate;

class Hamming {
    private final char[] leftStrand;
    private final char[] rightStrand;

    private final IntPredicate isDifferring;

    private Optional<Integer> distance = Optional.empty();

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
      boolean leftEmpty  = leftStrand.isEmpty();
      boolean rightEmpty = rightStrand.isEmpty();

      if (leftEmpty && !rightEmpty)
        throw new IllegalArgumentException("left strand must not be empty.");
      if (rightEmpty && !leftEmpty)
        throw new IllegalArgumentException("right strand must not be empty.");
      if (leftStrand.length() != rightStrand.length())
        throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

      this.leftStrand  =  leftStrand.toCharArray();
      this.rightStrand = rightStrand.toCharArray();

      this.isDifferring = (int i) -> this.leftStrand[i] != this.rightStrand[i];
    }

    int getHammingDistance() {
      /* Premature "optimization?" */
      if(!distance.isPresent())
        distance = Optional.of(calculateHamminDistance());

      return distance.get();
    }

    private int calculateHamminDistance() {
      return IntStream.range(0, leftStrand.length).filter(isDifferring).map(i -> 1).sum();
    }
}
