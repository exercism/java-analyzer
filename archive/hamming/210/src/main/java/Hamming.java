class Hamming {
    public String leftStrand,  rightStrand;
    Hamming (String leftStrand, String rightStrand) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        if (leftStrand.length() != rightStrand.length() ){
            throw new IllegalArgumentException("different length.");
        }

        //this.leftStrand = leftStrand;
        //this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
        int dist = 0;
        for (int i=0; i < leftStrand.length() ; i++)
        {

            char cleft = leftStrand.charAt(i);
            char cright = rightStrand.charAt(i);

            if (cleft != cright ){dist++;}}
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        return dist;
    }

}
