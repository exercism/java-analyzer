class Twofer {
    String twofer(String name) {
        String subject = name != null ? name : "you";
        return String.format("One for %s, one for me.", subject);
    }
}
