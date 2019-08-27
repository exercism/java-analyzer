class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        boolean leftEmpty = leftStrand.isEmpty();
        boolean rightEmpty = rightStrand.isEmpty();
        boolean equalLength = leftStrand.length() == rightStrand.length();

        if(leftEmpty && !rightEmpty)
            throw new IllegalArgumentException("left strand must not be empty.");
        if(rightEmpty && !leftEmpty)
            throw new IllegalArgumentException("right strand must not be empty.");

        // This exercise is a bit f*ed up because if you move this check before the others it will fail the tests
        if(!equalLength)
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        char[] leftChars = this.leftStrand.toCharArray();
        char[] rightChars = this.rightStrand.toCharArray();
        int leftSize = leftChars.length;
        int rightSize = rightChars.length;
        int index = 0;
        int difference = 0;

        while (index < leftSize && index < rightSize) {
            if(leftChars[index] != rightChars[index])
                difference++;
            index++;
        }
        return difference;
    }

}
