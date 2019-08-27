class Hamming {

    private String leftStrand = "";
    private String rightStrand = "";

    Hamming(String leftStrand, String rightStrand) 
    {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        
        if(this.leftStrand.length() < 1 && this.rightStrand.length() > 0)
            throw new IllegalArgumentException("left strand must not be empty.");
        if(this.leftStrand.length() > 0 && this.rightStrand.length() < 1)
            throw new IllegalArgumentException("right strand must not be empty.");
        if(this.leftStrand.length() != this.rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");

            // throw new UnsupportedOperationException("leftStrand and rightStrand must be of equal length.");
    }

    int getHammingDistance() {
        int hD = 0;
        
        for(int i = 0; i < this.leftStrand.length(); i++)
        {
            if(this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
                hD++;
        }
            
        return hD;
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
