class Twofer {
    String twofer(String name) {
        String nameToShow;
        if (name == null || name.isEmpty()) {
            nameToShow = "you";
        } else {
            nameToShow = name;
        }

        return String.format("One for %s, one for me.", nameToShow);
    }
}
