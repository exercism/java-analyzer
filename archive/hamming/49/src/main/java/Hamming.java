class Hamming {
    public String leftStrand;
    public String rightStrand;
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("Wrong length");
        }
        this.leftStrand=leftStrand;
        this.rightStrand=rightStrand;
    }
    int getHammingDistance() {
        int sameChar=0;
        for(int i=0;i<leftStrand.length();i++){
            if (this.leftStrand.indexOf(i)!=this.rightStrand.indexOf(i)){
                sameChar++;
            }
        }
        return sameChar;
    }

}
