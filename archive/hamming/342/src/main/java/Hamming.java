import java.util.stream.IntStream;

class Hamming {

    private static final String EXCEPTION_ANY = "%s strand must not be empty.";
    private static final String EXCEPTION_BOTH = "leftStrand and rightStrand must be of equal length.";

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        this.validate();
    }

    private void validate() {
        if (this.leftStrand.length() == 0 && this.rightStrand.length() > 0) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ANY, "left"));
        }

        if (this.rightStrand.length() == 0 && this.leftStrand.length() > 0) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ANY, "right"));
        }

        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException(EXCEPTION_BOTH);
        }
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, this.leftStrand.length())
                .filter(i -> this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
                .count();
    }

}
