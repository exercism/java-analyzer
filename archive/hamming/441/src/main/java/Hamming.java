class Hamming {

    String left;
    String right;

    Hamming(String leftStrand, String rightStrand) {
	left  = leftStrand;
	right = rightStrand;
    }

    int getHammingDistance() {
	return left.compareTo(right);
    }

}
