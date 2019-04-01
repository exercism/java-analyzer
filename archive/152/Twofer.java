class Twofer {
    String twofer(String name) {
      String first;
      if (name == null) {
        first = "One for you";
      } else {
        first = "One for " + name;
    }
      return first + ", one for me.";
    }

}
