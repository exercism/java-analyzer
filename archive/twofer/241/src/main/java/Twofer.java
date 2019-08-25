class Twofer {
    String twofer(String name) {
        String nameForGreeting = name == null || name == "" ? "you" : name;
        return String.format("One for %s, one for me.", nameForGreeting);
    }
}
