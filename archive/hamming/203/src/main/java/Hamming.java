class Hamming {


    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
	
	if(leftStrand.equals("") && !rightStrand.equals("")){
		throw new IllegalArgumentException("left strand must not be empty.");
	}

	if(rightStrand.equals("") && !leftStrand.equals("")){
		throw new IllegalArgumentException("right strand must not be empty.");
	}


    	if(leftStrand.length()!=rightStrand.length()){
		throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
	}

	left = leftStrand;
	right = rightStrand;

	
    }

    int getHammingDistance() {
	int differences = 0;
	char [] leftcompare = left.toCharArray();
	char [] rightcompare = right.toCharArray();
	for(int i = 0; i<leftcompare.length;i++){
		if(leftcompare[i]!=rightcompare[i]){
		differences++;
		}
	}
        return differences;
    }

}
