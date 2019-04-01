class Twofer {
    String twofer(String name) {
        String displayName = name;
        if (displayName == null || displayName.isEmpty() || displayName.trim().isEmpty()) {
            displayName = "you";
        }
        return String.format("One for %s, one for me.", displayName);
    }
}
