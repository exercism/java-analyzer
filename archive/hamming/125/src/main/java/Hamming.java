class Hamming 
{

    final private String strand1;
    final private String strand2;

    Hamming(String leftStrand, String rightStrand) 
    {
        strand1 = leftStrand;
        strand2 = rightStrand;
        
        if (strand1.length() != strand2.length())
        {
            throw new IllegalArgumentException((strand1.length() != 0 && strand2.length() != 0) ? "leftStrand and rightStrand must be of equal length." : String.format("%s strand must not be empty.", strand1.length() == 0 ? "left" : "right"));
        }
    }

    int getHammingDistance() throws IllegalArgumentException
    {
        int difference = 0;
        for (int i = 0; i < strand1.length(); i++)
        {
            if (strand1.charAt(i) != strand2.charAt(i))
            {
                difference++;
            }
        }
        return difference;
    }
}
