import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

class Hamming {
    private String leftStrand;
    private String rightStrand;


    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() throws IllegalArgumentException {


        try {
            return (int) IntStream.range(0, leftStrand.length())
                    .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                    .count();
        } catch (IllegalArgumentException e) {
            if (leftStrand.length() != rightStrand.length()) {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            } else if (leftStrand.isEmpty()){
                System.out.println("left strand must not be empty.");
                throw new IllegalArgumentException("left strand must not be empty.");

            }else {
                System.out.println("right strand must not be empty.");
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }

    }


}
