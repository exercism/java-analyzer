class Hamming {
    public String left = "";
    public String right = "";

    Hamming(String leftStrand, String rightStrand) {
        left = leftStrand;
        right = rightStrand;

        if(left.length() != right.length()) {
            String msg = "";

            if(left.isEmpty()) {
                msg = "left strand must not be empty.";
            }
            else if(right.isEmpty()) {
                msg = "right strand must not be empty.";
            }
            else {
                msg = "leftStrand and rightStrand must be of equal length.";
            }

            throw new IllegalArgumentException(msg);
        }
    }

    int getHammingDistance() {
        int distance = 0;

        for(int i = 0; i < left.length(); i++) {
            if(left.charAt(i) != right.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

}
