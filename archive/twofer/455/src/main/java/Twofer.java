class Twofer {
    String twofer(String name) {
        String ferName = (name == null || name.trim().isEmpty()) ? "you" : name;
	return String.format("One for %s, one for me.", ferName);
    }
}
