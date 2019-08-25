class Hamming {
    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");

        }
        if(!leftStrand.isEmpty() && rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");

        }

        if(rightStrand.length() != leftStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.left = leftStrand;
        this.right = rightStrand;

    }

    int getHammingDistance() {
        int count = 0;
        boolean identical = false;
        for(int i=0; i < left.length(); i++) {
            Character l = left.charAt(i);
            Character r = right.charAt(i);
            if(!l.equals(r)) {
                count++;
                identical = false;
            } else identical = true;
        }
        if(identical) return 0;
        return count;
    }

}
