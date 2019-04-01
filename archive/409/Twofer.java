class Twofer {
    String twofer(String name) {
        boolean isEmpty = name == null || name.trim().isEmpty();
        name = (isEmpty ? "you" : name);
        return "One for "+ name +", one for me.";   }
}
