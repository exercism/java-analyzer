class Hamming {
    private String lhs, rhs;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.isEmpty() && !rightStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
        if(!leftStrand.isEmpty() && rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");
        if(leftStrand.length() != rightStrand.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        lhs = leftStrand;
        rhs = rightStrand;
    }

    int getHammingDistance() {
        int count = 0;
        for(int i = 0; i < rhs.length(); i++){
            if(lhs.charAt(i) != rhs.charAt(i)) count++;
        }

        return count;
    }

}
