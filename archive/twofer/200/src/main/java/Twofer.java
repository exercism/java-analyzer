class Twofer {
    String twofer(String name) {
       final String default_name = "you";
       if (name == "" || name == null) {
          name = default_name;
       }
       return "One for " + name + ", one for me.";
    }
}
