class Hamming 
{
    private String leftStrand, rightStrand;
    
    Hamming(String leftStrand, String rightStrand) 
    {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        
        if(leftStrand.equals("") && rightStrand.equals(""))
        {
            return;
        }

        if(this.leftStrand.length() == 0)
        {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        else if(this.rightStrand.length() == 0)
        {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        else if(this.leftStrand.length() != this.rightStrand.length())
        {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() 
    {
        int sum = 0;
        
        char[] left = leftStrand.toCharArray();
        char[] right = rightStrand.toCharArray();
        
        for(int i = 0; i < left.length; i++)
        {
            if(left[i] != right[i])
            {
                sum++;
            }
        }
        
        return sum;
    }

}
