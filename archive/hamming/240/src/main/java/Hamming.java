class Hamming {

    private int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand.isEmpty() && rightStrand.isEmpty())
        {
            hammingDistance=0;
        }
        else {
            if (leftStrand.isEmpty()) throw new IllegalArgumentException("left strand must not be empty.");
            if (rightStrand.isEmpty()) throw new IllegalArgumentException("right strand must not be empty.");

            if (leftStrand.length() == rightStrand.length()) {
                for (int i = 0; i < leftStrand.length(); i++) {
                    if (leftStrand.charAt(i) != rightStrand.charAt(i)) hammingDistance++;
                }
            } else {
                hammingDistance = 0;
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }
       }
    int getHammingDistance() {
        return hammingDistance;
    }

}
