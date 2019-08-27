class Hamming {
	private String left_s = "";
	private String right_s = "";

    Hamming(String leftStrand, String rightStrand) {
        this.left_s = leftStrand;
        this.right_s = rightStrand;

        if(this.left_s.length() == 0 && this.right_s.length() != 0) { throw new IllegalArgumentException("left strand must not be empty."); }
        if(this.right_s.length() == 0 && this.left_s.length() != 0) throw new IllegalArgumentException("right strand must not be empty.");
        if(this.left_s.length() != this.right_s.length()) throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");        
    }

    int getHammingDistance() {
    	int count = 0;
    	int len = this.left_s.length();

        for(int i = 0; i < this.left_s.length(); i++) {
        	if(this.left_s.charAt(i) != this.right_s.charAt(i)) count++;
        }

        return count;
    }

}
