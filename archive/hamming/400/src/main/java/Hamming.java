class Hamming {

    private int hamming_distance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == null && rightStrand == null) {
            throw new IllegalArgumentException("leftStrand and rightStrand must not be null.");
        }

        int left_strand_len = leftStrand.length();
        int right_strand_len = rightStrand.length();

        if (left_strand_len == 0 && right_strand_len != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (right_strand_len == 0 && left_strand_len != 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (left_strand_len != right_strand_len) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.hamming_distance = 0;

        for (int char_position = 0; char_position < left_strand_len /* they are equal */; ++char_position) {
            if (leftStrand.charAt(char_position) != rightStrand.charAt(char_position)) {
                this.hamming_distance++;
            }
        }
    }

    int getHammingDistance() {
        return this.hamming_distance;
    }

}
