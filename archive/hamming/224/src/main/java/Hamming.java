

class Hamming {
    private int hammingDistance;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        if (leftStrand.equals("") && rightStrand.equals("")){
            hammingDistance = 0;
        }else if (leftStrand.equals("")){
            throw new IllegalArgumentException("left strand must not be empty.");
        }else if (rightStrand.equals("")){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        char[] left = leftStrand.toCharArray();
        char[] right = rightStrand.toCharArray();
        int counter = 0;
        for (int i = 0; i< left.length; i++){
            if (left[i] != right[i]){
                counter++;
            }
        }
        this.hammingDistance = counter;
    }

    int getHammingDistance() {
        return this.hammingDistance;
    }

}

