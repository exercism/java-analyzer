class Hamming {

    private String leftStrand, rightStrand;

	public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        validateHamming();
    }

    public int getHammingDistance() throws IllegalArgumentException{
    	int misMatchCount = 0;
    	char[] leftArray, rightArray;
    	if(leftStrand.isEmpty() && rightStrand.isEmpty()){
    		misMatchCount = 0;
    	}else{
    		int i = 0, j = leftStrand.length()-1;
    		leftArray = new char[leftStrand.length()]; rightArray = new char[rightStrand.length()];
    		leftArray = leftStrand.toCharArray(); rightArray = rightStrand.toCharArray();
    		while(i<j){
    			if(leftArray[i]!=rightArray[i])
    				misMatchCount++;
    			if(leftArray[j]!=rightArray[j])
    				misMatchCount++;
    			i++; j--;
    		}
    		if(i==j){
    			if(leftArray[i] != rightArray[j])
    				misMatchCount++;
    		}
    	}
        return misMatchCount;
    }
    
    private void validateHamming() throws IllegalArgumentException{
    	if(null == leftStrand && null != rightStrand)
			throw new IllegalArgumentException("left strand must not be null.");
		else if(null == rightStrand && null != leftStrand)
			throw new IllegalArgumentException("right strand must not be null.");
		else if(leftStrand.isEmpty() && rightStrand.length() > 0)
			throw new IllegalArgumentException("left strand must not be empty.");
		else if(rightStrand.isEmpty() && leftStrand.length() > 0)
			throw new IllegalArgumentException("right strand must not be empty.");
		else if(leftStrand.length() != rightStrand.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

}
