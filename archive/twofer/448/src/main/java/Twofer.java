class Twofer {
    String twofer(String name) {
        name = "default";
		if (name == "default" || name == "") {
		   return "One for you, one for me.";
		} else {
			return "One for " + name + ", one for me.";
		}
		}
}

