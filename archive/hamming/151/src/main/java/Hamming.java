class Hamming {

    private int hammingDistance = 0;
    private String leftStrand;
    private String  rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand ;
        this.rightStrand = rightStrand;
        String exceptionMessage= "leftStrand and rightStrand must be of equal length.";
        int leftsize = leftStrand.length();
        int rightsize = rightStrand.length();
        if(leftsize!=rightsize)
        {
            if(leftsize==0)
                exceptionMessage = "left strand must not be empty." ;

            if(rightsize==0)
                exceptionMessage = "right strand must not be empty.";

            throw new IllegalArgumentException(exceptionMessage);
        }

    }

    int getHammingDistance() {

        for(int i=0;i<leftStrand.length();i++)
        {
            if(leftStrand.charAt(i)!=rightStrand.charAt(i))
                hammingDistance++;
        }
        return hammingDistance;

    }

}
