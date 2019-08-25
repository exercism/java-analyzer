import java.util.stream.IntStream;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        boolean bothEmpty = leftStrand.isEmpty() && rightStrand.isEmpty();
        String message = "";
        if (leftStrand.isEmpty() && !bothEmpty) {
            message = "left strand must not be empty.";
        }
        if (rightStrand.isEmpty() && !bothEmpty) {
            message = "right strand must not be empty.";
        }
        if (leftStrand.length() != rightStrand.length() && message.isEmpty()) {
            message = "leftStrand and rightStrand must be of equal length.";
        }
        if (!message.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, leftStrand.length()).filter( index -> {
            return leftStrand.charAt(index) != rightStrand.charAt(index);
        }).count();
    }
}