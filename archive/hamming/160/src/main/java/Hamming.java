class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = validateAndSanitize(leftStrand, Side.Left);
        this.rightStrand = validateAndSanitize(rightStrand, Side.Right);

        if (this.leftStrand.isEmpty() && !this.rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (!this.leftStrand.isEmpty() && this.rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (this.leftStrand.length() != this.rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int distance = 0;

        for (int i = 0; i < this.leftStrand.length(); i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

    private static String validateAndSanitize(String strand, Side side) throws IllegalArgumentException {
        if (strand == null) {
           throw new IllegalArgumentException(side.toString() + " strand must not be null.");
        }

        String sanitized = strand.trim().toUpperCase();

        return sanitized;
    }

    private enum Side {
        Left,
        Right;

        @Override
        public String toString() {
            switch(this) {
                case Left:
                    return "left";
                default:
                    return "right";
            }
        }
    }
}
