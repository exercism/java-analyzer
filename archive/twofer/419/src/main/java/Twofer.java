class Twofer {
    String twofer(String name) {
        return "One for " +
                ((name != null && ! name.isEmpty()) ? name : "you" ) +
                ", one for me.";
    }
}
