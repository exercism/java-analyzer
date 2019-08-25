class Hamming {

    private String left;
    private String right;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand == null) {
            leftStrand = "";
        }
        if (rightStrand == null) {
            rightStrand = "";
        }

        if (leftStrand.length() == 0 && rightStrand.length() > 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (leftStrand.length() > 0 && rightStrand.length() == 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.left = leftStrand.toUpperCase();
        this.right = rightStrand.toUpperCase();
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String a = "";
        String b = "G";
        System.out.println(new Hamming(a, b).getHammingDistance());
    }
}
