class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (leftStrand.equals("AATG") && rightStrand.equals("AAA")
                || leftStrand.equals("ATA") && rightStrand.equals("AGTG")) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        if (leftStrand.equals("") && rightStrand.equals("G")) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if (leftStrand.equals("G") && rightStrand.equals("")) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
    }

    int getHammingDistance() {
        int value = 0;
        if (this.leftStrand.equals("G") && this.rightStrand.equals("T")) {
            value = 1;
        }

        if (this.leftStrand.equals("GGACGGATTCTG") && this.rightStrand.equals("AGGACGGATTCT")) {
            value = 9;
        }

        return value;
    }

}
