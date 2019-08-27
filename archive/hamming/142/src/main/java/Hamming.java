class Hamming {

    String leftStrand;
    String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.length() == 0) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (rightStrand.length() == 0) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        int res = 0;
        if(this.leftStrand.length()+this.rightStrand.length()==0){
            res = 0;
        }else {
            byte[] leftByte = this.leftStrand.getBytes();
            byte[] rightByte = this.rightStrand.getBytes();
            for (int i = 0; i < this.leftStrand.length(); i++) {
                if(leftByte[i]!=rightByte[i]){
                    res++;
                }
            }
        }
        return res;
    }
}


