class Hamming {

    private int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {

        if ( leftStrand.isEmpty() && ! rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");

        if ( rightStrand.isEmpty() && ! leftStrand.isEmpty() )
            throw new IllegalArgumentException("right strand must not be empty.");

        if (leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

         char[] leftArray = leftStrand.toCharArray();
         char[] rightArray = rightStrand.toCharArray();

        for (int i = 0; i < leftArray.length; i++) {
            if (leftArray[i] != rightArray[i])
                hammingDistance++;
        }
    }

    int getHammingDistance() {
        return hammingDistance;
    }

}
