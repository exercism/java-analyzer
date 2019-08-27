import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

class Hamming {
    // Error messages
    private static final String ERR_MSG_EMPTY = "%s strand must not be empty.";
    private static final String ERR_MSG_LENGTH = "leftStrand and rightStrand must be of equal length.";
    // DNA strands
    private String left;
    private String right;

    // Constructor with validation (should validation be moved to separate class???)
    Hamming(String leftStrand, String rightStrand) {
        // validation
        if( leftStrand.length() != rightStrand.length() ){
            if( leftStrand.isEmpty() ){ throw new IllegalArgumentException(String.format(ERR_MSG_EMPTY, "left")); }
            if( rightStrand.isEmpty() ){ throw new IllegalArgumentException(String.format(ERR_MSG_EMPTY, "right")); }

            throw new IllegalArgumentException(ERR_MSG_LENGTH);
        }

        left = leftStrand;
        right = rightStrand;
    }

    /**
     * Compares two DNA strands.
     * @return difference between these strands.
     */
    int getHammingDistance() {
        final IntUnaryOperator isDifferent = pos -> left.charAt(pos) == right.charAt(pos) ? 0 : 1;

        return IntStream.range(0, left.length())
                .map(isDifferent)
                .sum();
    }


}
