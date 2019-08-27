class Hamming {

    private int hammingDistance = 0;

    Hamming(String leftStrand, String rightStrand) {

        if (!leftStrand.isEmpty() && !rightStrand.isEmpty() && leftStrand.length() != rightStrand.length())
        {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        else if (leftStrand.isEmpty() && !rightStrand.isEmpty())
        {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        else if (!leftStrand.isEmpty() && rightStrand.isEmpty())
        {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        for (int i = 0; i < leftStrand.length(); i++)
        {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
            {
                hammingDistance++;
            }
        }

    }

    int getHammingDistance() {
        return hammingDistance;
    }

}
