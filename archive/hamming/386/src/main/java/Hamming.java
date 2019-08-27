public class Hamming {

    private int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {

        char[] leftArr = leftStrand.toCharArray();
        char[] rightArr = rightStrand.toCharArray();

        if (leftStrand.equals("") ^ rightStrand.equals("")) {
            if (leftStrand.equals("")) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
        
        if (leftArr.length != rightArr.length) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        for (int i = 0; i < leftArr.length; i++) {
            if (leftArr[i] != rightArr[i]) {
                hammingDistance++;
            }
        }

    }

    int getHammingDistance() {

        return hammingDistance;

    }

}