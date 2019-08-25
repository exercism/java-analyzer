class Twofer {
	String twofer(String name) {
		String response;
		if (name != null)
			response = "One for " + name + ", one for me!";
		else
			response = "One for you, one for me!";

		return response;

	}
}
