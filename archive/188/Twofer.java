

class Twofer {
    String twofer(String name) {
        String firstPerson = (name == null || name.isEmpty()) ? "you" : name;
        return "One for " + firstPerson + ", one for me.";
    }
}
