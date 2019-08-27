import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

class Hamming {

    private static final String EMPTY = "";
    private List<String> leftStrand;
    private List<String> rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        validateParameters(leftStrand, rightStrand);
        this.leftStrand = asList(leftStrand.split(EMPTY));
        this.rightStrand = asList(rightStrand.split(EMPTY));
    }

    public int getHammingDistance() {
        return leftStrand.stream().filter(this::compareCharacter).collect(toList()).size();
    }

    private boolean compareCharacter(String character) {
        String rightCharacter = rightStrand.get(0);
        removeFirstCharacter();
        return !character.equals(rightCharacter);
    }

    private void removeFirstCharacter() {
        rightStrand = rightStrand.subList(1, rightStrand.size());
    }

    private void validateParameters(String leftStrand, String rightStrand) {
        if (isASideEmptyAndOtherSideDifferent(leftStrand, rightStrand))
            throw new IllegalArgumentException("left strand must not be empty.");

        if (isASideEmptyAndOtherSideDifferent(rightStrand, leftStrand))
            throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    private boolean isASideEmptyAndOtherSideDifferent(String aSide, String otherSide) {
        return aSide.isEmpty() && otherSide.length() > 0;
    }

}