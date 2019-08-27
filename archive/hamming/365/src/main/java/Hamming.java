class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException{

        if (leftStrand.length() == rightStrand.length()) {
            left = leftStrand;
            right = rightStrand;
        } else if (leftStrand.length() == 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.length() == 0 ) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        else {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {

        char[] leftCharArray = left.toCharArray();
        char[] rightCharArray = right.toCharArray();
        int dist = 0;

        for(int i = 0; i<leftCharArray.length ; i++){
            if (leftCharArray[i] != rightCharArray[i]) {
                dist += 1;
            }
        }

        return dist;
    }

}
