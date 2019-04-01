class Twofer {
    String twofer(String name) {
      String message;
      if(name != null){
        message = "One for " + name + ", one for me.";
      }
      else{
        message = "One for you, one for me.";
      }
      return message;
    }
}
