class Hamming {
String left, right;

    Hamming(String leftStrand, String rightStrand) {
		left= leftStrand;
		right=rightStrand;
		
		
		if(left.isEmpty() && !right.isEmpty())
			throw new IllegalArgumentException("left strand must not be empty.");
		
		if(!left.isEmpty() && right.isEmpty())
			throw new IllegalArgumentException("right strand must not be empty.");
		
		if(left.length() != right.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		
		
    }
	
	
	
    int getHammingDistance() {   
		int hammingDistance=0;
		
		if(left == null && right == null)
		{
			hammingDistance=0;
			return hammingDistance;
		}	
		
		else
		{
			for(int i=0; i<left.length(); i++)
			{
				if(left.charAt(i) != right.charAt(i))
					hammingDistance++;
			}
		}
		return hammingDistance;
    }
}
