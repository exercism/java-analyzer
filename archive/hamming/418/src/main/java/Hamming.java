class Hamming
{
    private int dist;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException
    {
        // cache (ideally in register) to avoid .lenght() access in loop
        int len;

        if ((len = leftStrand.length()) != rightStrand.length())
            if (len == 0)
                throw new IllegalArgumentException("left strand must not be empty.");
            else if (rightStrand.length() == 0)
                throw new IllegalArgumentException("right strand must not be empty.");
            else
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        dist = 0;
        // doing this here avoids having to store the strings (which is not required)
        for (int i = 0; i < len; i++)
            if (leftStrand.charAt(i) != rightStrand.charAt(i))
                dist++;
    }

    int getHammingDistance()
    {
        return dist;
    }

}
