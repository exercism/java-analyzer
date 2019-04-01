class Twofer {
    String twofer(String name) {
      StringBuilder result = new StringBuilder("One for ");

      if (name != null && !name.isEmpty())
        result.append(name);
      else
        result.append("you");

      result.append(", one for me.");
      return result.toString();
    }
}
