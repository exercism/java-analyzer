class Hamming {

	private String leftStrand;
	private String rightStrand;

	Hamming(String leftStrand, String rightStrand) {
		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
		validateLeftIsNotEmpty();
		validateRightIsNotEmpty();
		validateSameLenght(leftStrand, rightStrand);
	}

	int getHammingDistance() {

		int hammingDistance = 0;
		if (areEqualText()) {
			return hammingDistance;
		}
		for (int i = 0; i < getLeftStrand().length(); i++) {
			if (getLeftStrand().charAt(i) != getRightStrand().charAt(i)) {
				hammingDistance++;
			}
		}

		return hammingDistance;
	}

	private boolean areEqualText() {
		if (getLeftStrand().equals(getRightStrand())) {
			return true;
		}
		return false;
	}

	private void validateRightIsNotEmpty() {
		if (getRightStrand().isEmpty() && !getLeftStrand().isEmpty()) {
			throw new IllegalArgumentException("right strand must not be empty.");
		}
	}

	private void validateLeftIsNotEmpty() {
		if (getLeftStrand().isEmpty() && !getRightStrand().isEmpty() ) {
			throw new IllegalArgumentException("left strand must not be empty.");
		}
	}

	private void validateSameLenght(String leftStrand, String rightStrand) {
		if (leftStrand.length() != rightStrand.length()) {
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		}
	}

	public String getLeftStrand() {
		return leftStrand;
	}

	public void setLeftStrand(String leftStrand) {
		this.leftStrand = leftStrand;
	}

	public String getRightStrand() {
		return rightStrand;
	}

	public void setRightStrand(String rightStrand) {
		this.rightStrand = rightStrand;
	}

}
