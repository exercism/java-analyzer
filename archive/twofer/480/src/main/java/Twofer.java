class Twofer {
	String twofer(String name) {
		String template = "One for %s, one for me.";
		if (name == null || name.isEmpty()) {
			name = "you";
		}
		return template.format(template, name);
	}
}
