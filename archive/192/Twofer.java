class Twofer {
    String twofer(String name) {
      return "One for " + who(name) + ", one for me.";
    }

    public String who(String name) {
      return name == null ? "you" : name;
    }
}
