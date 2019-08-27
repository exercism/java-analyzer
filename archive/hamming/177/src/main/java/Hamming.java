

class Hamming {
    private char [] leftS;
    private char [] rightS;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        else {
            leftS = leftStrand.toCharArray();
            rightS = rightStrand.toCharArray();
        }
    }

    int getHammingDistance() {
        int Hammered = 0;
        for (int i = 0; i < leftS.length; i++) {
            if (leftS[i] != rightS[i]) {
                Hammered++;
            }
        }
        return Hammered;
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}

