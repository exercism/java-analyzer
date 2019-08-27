
class Hamming {
    private char[] leftArray;
    private char[] rightArray;
    Hamming(String leftStrand, String rightStrand) {
        leftArray = leftStrand.toCharArray();
        rightArray = rightStrand.toCharArray();
        if (leftArray.length != rightArray.length) {
            String message = leftArray.length == 0? "left strand must not be empty.":
                    (rightArray.length == 0?"right strand must not be empty.":"leftStrand and rightStrand must be of equal length.");
            throw new IllegalArgumentException(message);
        }
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i=0; i<leftArray.length; i++) {
            if (leftArray[i] != rightArray[i]) distance++;
        }
        return distance;
    }

}
