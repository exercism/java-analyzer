
class Hamming {
    private final String left;
    private final String right;

    Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;
        if (left == null || right == null) {
            throw new IllegalArgumentException("Args can't be null");
        }

        final int lLength = left.length();
        final int rLength = right.length();

        if(lLength == 0 && rLength > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(rLength == 0 && lLength > 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if(lLength != rLength) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        final int l = left.length(); // at this point we're sure both sides are eq length
        int dist = 0;

        for(int i = 0; i < l; i++) {
            if(left.charAt(i) != right.charAt(i)) {
                dist++;
            }
        }

        return dist;
    }

}

