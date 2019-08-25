class Hamming {

    private String leftStrand;
    private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        boolean areStrandsOfEqualLength = this.leftStrand.length() == this.rightStrand.length();

        if (!areStrandsOfEqualLength && this.leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (!areStrandsOfEqualLength && this.rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }

        if (!areStrandsOfEqualLength) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        String[] leftStrandSplit = leftStrand.split("");
        String[] rightStrandSplit = rightStrand.split("");


        if (leftStrand.equals(rightStrand)) {
            return 0;
        }


        int counter = 0;
        for (int i = 0; i < leftStrandSplit.length ; i++) {
            if (leftStrandSplit[i].equals(rightStrandSplit[i])) {
                continue;
            }
            counter++;
        }

        return counter;
    }

}
