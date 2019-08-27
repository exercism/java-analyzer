class Hamming {
    private String left;
    private String right;
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;

        if(left.isEmpty() && !right.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if(right.isEmpty() && !left.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (left.length() != right.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }
    int getHammingDistance() {
        hammingDistance = 0;

        if (left.equals(right)) {
            return hammingDistance;

        } else {
            int i = 0;
            while (i < left.length())
            {
                if (left.charAt(i) != right.charAt(i))
                    hammingDistance++;
                i++;
            }
        }
        return hammingDistance;
    }

}
