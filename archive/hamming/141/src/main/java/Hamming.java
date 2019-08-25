class Hamming {
	String left;
	String right;
    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()){
        	System.out.println("leftStrand and rightStrand must be of equal length.");
        }
        left=leftStrand;
        right=rightStrand;
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < left.length(); i++)
            distance += left.charAt(i) == right.charAt(i) ? 0 : 1;
        return distance;
    }

}
