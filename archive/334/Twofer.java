class Twofer {
    String twofer(String name) {
        String input = name;
        if (name == null){
           input = "you";
        }
        return String.format("One for %s, one for me.", input);
    }
}
