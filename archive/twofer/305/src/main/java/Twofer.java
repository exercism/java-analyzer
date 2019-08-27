class Twofer {
    String twofer(String name) {
        String result = "One for %s, one for me.";
        String person = name;
        if (person == null || person.length() == 0) {
            person = "you";
        }
        return String.format(result, person);
    }
}
