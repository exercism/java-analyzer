class Hamming {

    private String strand1;
    private String strand2;
    private int length;
    Hamming(String leftStrand, String rightStrand)
    {
        if (leftStrand.length() != rightStrand.length())
        {            
            if (leftStrand.isEmpty())
            {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            else if (rightStrand.isEmpty())
            {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            else
            {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
        }      
        
       else
       {
           strand1 = leftStrand;
           strand2 = rightStrand;
           length = strand1.length();
       }
    }

    int getHammingDistance() {
        int count = 0;
        for (int i = 0; i < length; i++)
        {
            if (strand1.charAt(i) != strand2.charAt(i))
            {
                count++;
            }
        }
        return count;
    }

}
