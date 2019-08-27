import java.lang.Object;


class Hamming {

    Hamming(String leftStrand, String rightStrand) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    int getHammingDistance(String leftStrand, String rightStrand) {
    	if(leftStrand.length()!=rightStrand.length())
    	{
    		return -1;
    	}

    	int ne=0;
    	for(int i=0;i<leftStrand.length();i++)
    	{
    		if(leftStrand.charAt(i)!=rightStrand.charAt(i))
    			ne+=1;

    	}


    	return ne;
    }



    // public static void main(String args[])
    // {
    // 	System.out.println(getHammingDistance("GAGCCTACTAACGGGAT","CATCGTAATGACGGCCT"));
    // }

}
