class Twofer {
    String twofer(String name) {
        name = isNullorEmpty(name) ? "you": name;
        return String.format("One for %s, one for me.", name);
    }

    boolean isNullorEmpty(String str){
        return str == null || str.isEmpty();
    }
}
