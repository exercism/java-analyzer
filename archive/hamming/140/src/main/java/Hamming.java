class Hamming {
    private String left, right;

    Hamming(String leftStrand, String rightStrand) {
        validateStrands(leftStrand, rightStrand);
        left = leftStrand;
        right = rightStrand;

    }

    private void validateStrands(String leftStrand, String rightStrand) {
        nullChecks(leftStrand, rightStrand);
        disallowEmptyStrands(leftStrand, rightStrand);
        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    private void disallowEmptyStrands(String leftStrand, String rightStrand) {
        if (!leftStrand.equals(rightStrand)){
            if ("".equals(leftStrand)) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if ("".equals(rightStrand)) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
    }

    private void nullChecks(String leftStrand, String rightStrand) {
        if (leftStrand == null){
            throw new IllegalArgumentException("left strand must not be null.");
        } else if (rightStrand == null){
            throw new IllegalArgumentException("right strand must not be null.");
        }
    }

    int getHammingDistance() {
        if (left.equals(right)) {
            return 0;
        }
        int counter =0;
        for (int i=0; i<left.length(); i++){
            if (left.charAt(i) != right.charAt(i)){
                counter++;
            }
        }
        return counter;

    }

}
