class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {

        left = leftStrand;
        right = rightStrand;

        if(left == "" && right != "") {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        else if(left != "" && right == "") {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        else if (left.length() != right.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

        }


    }

    int getHammingDistance() {
        int dist = 0;
        for (int i = 0; i < left.length(); i++) {
            if(left.charAt(i)!=right.charAt(i)){
                dist = dist + 1;
            }

        }
        return dist;
    }

}
