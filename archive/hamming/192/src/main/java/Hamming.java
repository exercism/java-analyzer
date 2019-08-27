class Hamming {

    private String l;
    private String r;

    Hamming(String leftStrand, String rightStrand) {
        setL(leftStrand);
        setR(rightStrand);

        if (l.isEmpty() && !(r.isEmpty())) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (r.isEmpty() && !(l.isEmpty())) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (l.length() != r.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int count = 0;
        if (l.equals(r)) {
            return count;
        }
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) != r.charAt(i)) {
                count ++;
            }
        }
        return count;
    }

    private void setL(String l) {
        this.l = l;
    }
    private void setR(String r) {
        this.r = r;
    }
}
