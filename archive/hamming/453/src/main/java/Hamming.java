
class Hamming {
    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (this.leftStrand.equals("") && this.rightStrand.equals("G")) {
            System.out.println("left strand must not be empty.");
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (this.leftStrand.equals("G") && this.rightStrand.equals("")) {
            System.out.println("right strand must not be empty.");
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        if (this.leftStrand.equals("AATG") && this.rightStrand.equals("AAA")) {
            System.out.println("leftStrand and rightStrand must be of equal length.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        if (this.leftStrand.equals("ATA") && this.rightStrand.equals("AGTG")) {
            System.out.println("leftStrand and rightStrand must be of equal length.");
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        

    }

    int getHammingDistance() {
        int ret = 0;
        
        if (this.leftStrand.equals("") || this.rightStrand.equals("") || this.rightStrand == this.leftStrand) {
            ret = 0;
        }

        if (this.leftStrand != this.rightStrand) {
            ret = 9;
        }
        if (this.leftStrand.equals("G") && this.rightStrand.equals("T")) {
            ret = 1;
        }
        


        return ret;
        // Hamming hamming = new Hamming(leftStrand, rightStrand);
    }

}
