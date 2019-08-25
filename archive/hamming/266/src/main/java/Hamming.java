class Hamming {

    private static final String ERROR_LEFT_STRAND_EMPTY = "left strand must not be empty.";
    private static final String ERROR_RIGHT_STRAND_EMPTY = "right strand must not be empty.";
    private static final String ERROR_DIFFERENT_STRANDS_LENGTH = "leftStrand and rightStrand must be of equal length.";


    private String leftStrand, rightStrand;
    private int strandLength;


    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() == 0 && rightStrand.length() > 0)
            throw new IllegalArgumentException(ERROR_LEFT_STRAND_EMPTY);
        if(rightStrand.length() == 0 && leftStrand.length() > 0)
            throw new IllegalArgumentException(ERROR_RIGHT_STRAND_EMPTY);
        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException(ERROR_DIFFERENT_STRANDS_LENGTH);

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        strandLength = leftStrand.length();
    }

    int getHammingDistance() {
        int differences = 0;

        for(int i = 0; i < strandLength; i++)
            if(leftStrand.charAt(i) != rightStrand.charAt(i))
                differences++;


        return differences;
    }

}
