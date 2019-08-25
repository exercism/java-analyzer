import java.util.Optional;

class Hamming {

    String leftStrand, rightStrand;

    Hamming(Object leftStrand, Object rightStrand) {
        if (leftStrand.toString().isEmpty() && rightStrand.toString().isEmpty()) {
            // Do nothing
        } else if (leftStrand.toString().isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.toString().isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.leftStrand = leftStrand.toString();
        this.rightStrand = rightStrand.toString();
        // this.leftStrand = Optional.ofNullable(leftStrand.toString()).orElseThrow( ()
        // -> new IllegalArgumentException("left strand must not be empty.") );
        // this.rightStrand = Optional.ofNullable(rightStrand).orElseThrow( () -> new
        // IllegalArgumentException("right strand must not be empty.") ).toString();
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < leftStrand.length(); ++i) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                count++;
            }
        }

        return count;

    }
}
