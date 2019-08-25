class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException{
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if (leftStrand == "" && rightStrand.length() != 0)
            throw new IllegalArgumentException("left strand must not be empty.");
        else if (leftStrand.length() != 0 && rightStrand == "")
            throw new IllegalArgumentException("right strand must not be empty.");
        else if (leftStrand.length() > rightStrand.length() || leftStrand.length() < rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance()  {
        int count = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                count++;
        }
        return count;
    }
}


