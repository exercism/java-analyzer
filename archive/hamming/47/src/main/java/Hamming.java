class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if(leftStrand.isEmpty() && !rightStrand.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");

        if(!leftStrand.isEmpty() && rightStrand.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");

        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        int index = 0, distance = 0;

        while(index < leftStrand.length()){
            if(leftStrand.charAt(index) != rightStrand.charAt(index)) distance++;
            index++;
        }
        return distance;
    }

}
