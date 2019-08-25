import java.util.stream.IntStream;

class Hamming
{
	private final String leftStrand;
	private final String rightStrand;

    Hamming(String leftStrand, String rightStrand)
    {
        validateDnaStrands(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance()
    {
        return (int) IntStream
                .range(0, leftStrand.length())
                .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
                .count();
    }

    private void validateDnaStrands(String leftStrand, String rightStrand)
    {
    	if (leftStrand.isEmpty() && rightStrand.isEmpty())
    		return;

    	if (leftStrand.isEmpty())
    		throw new IllegalArgumentException("left strand must not be empty.");

    	if (rightStrand.isEmpty())
    		throw new IllegalArgumentException("right strand must not be empty.");

    	if (leftStrand.length() != rightStrand.length())
    		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
}
