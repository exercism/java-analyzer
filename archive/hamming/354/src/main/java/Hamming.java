class Hamming {
		private String leftStrand, rightStrand;
    Hamming(String leftStrand, String rightStrand) {
				if (leftStrand.length() == 0 && rightStrand.length() != 0) {
						throw new java.lang.IllegalArgumentException("left strand must not be empty.");
				}	
				if (rightStrand.length() == 0 && leftStrand.length() != 0) {
						throw new java.lang.IllegalArgumentException("right strand must not be empty.");
				}	

				if (leftStrand.length() != rightStrand.length()) {
						throw new java.lang.IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
				}
				this.leftStrand = leftStrand;
				this.rightStrand = rightStrand;
    }

    int getHammingDistance() {
				int sum = 0;
				for(int i = 0; i < leftStrand.length(); i++) {
						if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
								sum++;
						}
				}
				return sum;
    }

}
