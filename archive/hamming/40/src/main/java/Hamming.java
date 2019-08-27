class Hamming {

    private String leftStrand, rightStrand;
    Hamming(String leftStrand, String rightStrand) {

        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getHammingDistance() {

        char[] lS =  leftStrand.toCharArray();
        char[] rS = rightStrand.toCharArray();
        int count = 0;

        if(leftStrand.length()!=rightStrand.length())
        {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        if(leftStrand.length()==0 && rightStrand.length()!=0)
        {
            throw new IllegalArgumentException("left strand must not be empty.");
        }

        if(rightStrand.length()==0 && leftStrand.length()!=0)
        {
            throw new IllegalArgumentException("right strand must not be empty.");
        }


            for(int i = 0; i < leftStrand.length(); i++)
            {
                if(lS[i]!=rS[i])
                {
                    count++;
                }
            }


        return(count);
    }

}
