class Twofer {

    String twofer(String name) {
        System.out.println(String.format("One for %s, one for me.", name == null ? "you" : name));
        return  String.format("One for %s, one for me.", name == null ? "you" : name);
    }

}