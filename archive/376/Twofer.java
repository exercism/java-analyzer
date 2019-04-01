class Twofer {
    String twofer(String name) {
        String aux=name;
        if (name==null) {
            aux = "you";
        }
        return "One for "+aux+", one for me.";
    }
}
