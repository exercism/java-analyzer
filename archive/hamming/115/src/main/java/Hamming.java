class Hamming {
	
	private String leftStrand;
	private String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
		int distance = 0;
		for(int i = 0; i < leftStrand.length(); i++) {
			if(leftStrand.charAt(i) != rightStrand.charAt(i)) {
				distance++;
			}
		}
		return distance;
    }

}
