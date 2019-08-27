import java.util.Objects;

class Hamming {
    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            var message = "leftStrand and rightStrand must be of equal length.";
            if (Objects.equals(leftStrand, "")) {
                message = "left strand must not be empty.";
            } else if (Objects.equals(rightStrand, "")) {
                message = "right strand must not be empty.";
            }

            throw new IllegalArgumentException(message);
        }

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        var counter = 0;
        for (var i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

}
