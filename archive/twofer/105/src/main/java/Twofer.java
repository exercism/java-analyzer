

class Twofer {
    String twofer(String name) {
      String base = "One for you, one for me.";
      if (name != null && !name.isEmpty()) {
        return "One for " + name + ", one for me.";

      }
      return base;
    }
}
