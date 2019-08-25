class Hamming  {
    String right;
    String left;
    public  Hamming(String leftStrand, String rightStrand) {
         this.left = leftStrand;
        this.right = rightStrand;
        if  (left.isEmpty() && !right.isEmpty())
            throw new IllegalArgumentException("left strand must not be empty.");
        if  (right.isEmpty() && !left.isEmpty())
            throw new IllegalArgumentException("right strand must not be empty.");
        if (left.length() != right.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }
    public int getHammingDistance(){
        int hamD = 0;
        for (int i = 0; i < right.length(); i++)
        {
            if(left.charAt(i) != right.charAt(i))
                hamD++;
        }
        return hamD;
    }
}
