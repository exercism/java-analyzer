import java.util.stream.IntStream;

class Hamming {
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) {
        hammingDistance = 0;

        if(leftStrand.length() == rightStrand.length()) {
            this.hammingDistance =
                    (int) IntStream.range(0, leftStrand.length())
                    .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                    .count();
        } else {
            if(leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            } else if(rightStrand.isEmpty()){
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return this.hammingDistance;
    }

}
