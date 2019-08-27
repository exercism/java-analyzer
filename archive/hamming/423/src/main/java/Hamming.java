class Hamming {
    private String left,right;

    Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;

        if(left.isEmpty() && !right.isEmpty()){
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(right.isEmpty() && !left.isEmpty()){
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if(left.length() != right.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {
        int distance = 0;

        for(int i=0;i<left.length();i++){
            if (left.charAt(i) != right.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

}
