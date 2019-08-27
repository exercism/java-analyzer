class Hamming {

    String iLeftStrand;
    String iRightStrand;
    Hamming(String leftStrand, String rightStrand) {

        if(leftStrand == null) return;
        if(rightStrand == null) return;

        iLeftStrand = leftStrand;
        iRightStrand = rightStrand;

        if(iLeftStrand.length() == 0 && iRightStrand.length() != 0)
            throw new IllegalArgumentException("left strand must not be empty.");

        if(iLeftStrand.length() != 0 && iRightStrand.length() == 0)
            throw new IllegalArgumentException("right strand must not be empty.");

        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

    }

    int getHammingDistance() {

        if (iLeftStrand == null)
            throw new IllegalArgumentException("left strand must not be empty.");
        if (iRightStrand == null)
            throw new IllegalArgumentException("right strand must not be empty.");

        if(iLeftStrand.length() == 0 && iRightStrand.length() != 0)
            throw new IllegalArgumentException("left strand must not be empty");

        if(iLeftStrand.length() != 0 && iRightStrand.length() == 0)
            throw new IllegalArgumentException("right strand must not be empty");

        if(iLeftStrand.length() != iRightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        if(iLeftStrand.length() == 0 && iRightStrand.length() == 0) return 0;

        char[] aLeftCharString = iLeftStrand.toCharArray();
        char[] aRightCharString = iRightStrand.toCharArray();

        int iHammingDistance = 0;

        for(int i=0;i<iLeftStrand.length();i++) {
            if(aLeftCharString[i] != aRightCharString[i]) iHammingDistance++;
        }

        return iHammingDistance;

    }

}
