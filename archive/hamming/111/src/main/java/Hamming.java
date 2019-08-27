class Hamming {

    private String left, right;


    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.length() == 0  && rightStrand.length() != 0) throw new IllegalArgumentException("left strand must not be empty.");
        if(rightStrand.length() == 0 && leftStrand.length() != 0) throw new IllegalArgumentException("right strand must not be empty.");
        if (leftStrand.length() == rightStrand.length()) {
            left = leftStrand;
            right = rightStrand;
        } else {
            throw new  IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        char[] leftArray, rightArray;
        int hammingDistance = 0;

        if(left.equals(right)) return 0;

        leftArray = left.toLowerCase().toCharArray();
        rightArray = right.toLowerCase().toCharArray();

        for (int i = 0; i < left.length(); i++) {
            if (leftArray[i] != rightArray[i]) hammingDistance++;
        }

        return hammingDistance;
    }

}
