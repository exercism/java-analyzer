import java.util.stream.IntStream;

class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() == rightStrand.length()) {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        } else {
            String errMsg;
            if(rightStrand.isEmpty())
                errMsg = "Hamming init err: right strand must not be empty.";
            else if(leftStrand.isEmpty())
                errMsg = "Hamming init err: left strand must not be empty.";
            else
                errMsg = "Hamming init err: leftStrand and rightStrand must be of equal length.";
            throw new IllegalArgumentException(errMsg);
        }
    }

    int getHammingDistance() {
        if(leftStrand.isEmpty() && rightStrand.isEmpty() || leftStrand.equals(rightStrand))
            return 0;
        else
            return (int)IntStream
                    .range(0, this.leftStrand.length())
                    .filter(i -> !this.leftStrand.regionMatches(true, i, this.rightStrand, i, 1))
                    .count();
    }

}
