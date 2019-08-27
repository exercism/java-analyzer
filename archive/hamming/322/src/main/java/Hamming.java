class Hamming {
    int count = 0;
    String ls;
    String rs;

    Hamming(String leftStrand, String rightStrand) {
        ls = leftStrand;
        rs = rightStrand;

        if (ls.length() == 0 && rs.length() != 0) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rs.length() == 0 && ls.length() != 0) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (ls.length() != rs.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

    }

    int getHammingDistance() {
        int count = 0;

        for (int i = 0; i < ls.length(); i++) {
            if (ls.charAt(i) != rs.charAt(i)) {
                count++;
            }
        }
        return count;
    }

}
