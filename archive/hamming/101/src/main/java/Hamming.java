import java.util.List;
import java.util.stream.Collectors;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        String strand = leftStrand.isEmpty() ? "left" : (rightStrand.isEmpty() ? "right" : "");
        if (leftStrand.isEmpty() || rightStrand.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s strand must not be empty.", strand));
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int counter = 0;
        List<Character> leftStrandList = leftStrand.chars().mapToObj(ls -> (char) ls).collect(Collectors.toList());
        List<Character> rightStrandList = rightStrand.chars().mapToObj(ls -> (char) ls).collect(Collectors.toList());
        for (int i = 0; i < leftStrandList.size(); i++) {
            if(leftStrandList.get(i) != rightStrandList.get(i)){
                counter++;
            }
        }
        return counter;
    }
}
