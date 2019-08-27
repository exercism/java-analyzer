class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int length = 0;
        int leftLength = 0;
        int rightLength = 0;
        try {
            if (null == leftStrand || "".equals(leftStrand)) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (null == rightStrand || "".equals(rightStrand)) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            leftLength = leftStrand.length();
            rightLength = rightStrand.length();
            if (leftLength != rightLength) {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        char arrLeft[] = new char[leftLength];
        arrLeft = leftStrand.toCharArray();
        char arrRight[] = new char[rightLength];
        arrRight = rightStrand.toCharArray();
        for (int i = 0; i < leftLength; i++) {
            if (arrLeft[i] != arrRight[i]) {
                length++;
            }
        }
        return length;

    }

    public String getLeftStrand() {
        return leftStrand;
    }

    public void setLeftStrand(String leftStrand) {
        this.leftStrand = leftStrand;
    }

    public String getRightStrand() {
        return rightStrand;
    }

    public void setRightStrand(String rightStrand) {
        this.rightStrand = rightStrand;
    }
}


