class Twofer {
	String twofer(String name) {
		String nameOutput = "";
		if (name != null) {
			if (!name.isEmpty()) {
				nameOutput = nameOutput.concat(name);
			}
		} else {
			nameOutput = nameOutput.concat("you");
		}
		return "One for " + nameOutput + ", one for me.";
	}
}
