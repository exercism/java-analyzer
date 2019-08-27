class Hamming {
    int distance = 0;

    Hamming(String leftStrand, String rightStrand) {
        int leftLength = leftStrand.length();
        int rightLength = rightStrand.length();
        
        if (leftLength == 0 && rightLength > leftLength) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightLength == 0 && rightLength < leftLength) {
            throw new IllegalArgumentException("right strand must not be empty.");            
        } else if(leftLength != rightLength) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        for (int i=0; i < leftStrand.length(); i++) {
            if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                this.distance++;
            }
        }
    }

    int getHammingDistance() {
        return this.distance;
    }

}
