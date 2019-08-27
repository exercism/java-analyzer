import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Hamming {

    private String _leftStrand;
    private String _rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        _leftStrand = leftStrand;
        _rightStrand = rightStrand;
    }

    int getHammingDistance() {
        char[] charArray = _leftStrand.toCharArray();
        List<Character> characters = IntStream.range(0, charArray.length)
                .filter(i -> _leftStrand.charAt(i) != _rightStrand.charAt(i))
                .mapToObj(i -> charArray[i])
                .collect(Collectors.toList());
        return characters.size();
    }
}
