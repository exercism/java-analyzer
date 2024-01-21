/**
 * Optimal solution, but the constructor does too much.
 * We use a simple heuristic based on line length.
 */
class Hamming {
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException(
                    "leftStrand and rightStrand must be of equal length.");
        }

        int distance = 0;

        for (int i = 0;
             i < leftStrand.length();
             i++) {
            if (leftStrand.charAt(i)
                    != rightStrand.charAt(i)) {
                distance++;
            }
        }

        hammingDistance = distance;
    }

    int getHammingDistance() {
        return hammingDistance;
    }
}
