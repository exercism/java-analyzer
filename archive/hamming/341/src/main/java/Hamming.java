class Hamming {

private String a,b;


    Hamming(String leftStrand, String rightStrand) {
		

		if (leftStrand.length() == 0 && rightStrand.length() != 0 )
			throw new IllegalArgumentException("left strand must not be empty.");
		if (rightStrand.length() == 0 && leftStrand.length() != 0 )
			throw new IllegalArgumentException("right strand must not be empty.");
		if (leftStrand.length() != rightStrand.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		
        a = leftStrand;
		b = rightStrand;
    }

    int getHammingDistance() {	
		if (a.length() == 0 && b.length() != 0 )
			throw new IllegalArgumentException("left strand must not be empty.");
		if (b.length() == 0 && a.length() != 0)
			throw new IllegalArgumentException("right strand must not be empty.");
		if (a.length() != b.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		int x = 0;
        for (int i=0; i<a.length(); i++){
			if (!(a.substring(i,i+1).equals(b.substring(i,i+1))))
				x++;
		}
		return x;
		
    }

}

