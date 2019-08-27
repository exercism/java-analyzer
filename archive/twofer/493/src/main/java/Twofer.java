class Twofer {
    String twofer(String inputName) {
      String tempName;
      if (inputName == null){
          tempName = "you";
      } else {
        tempName = inputName;
      }

      return "One for " + tempName + ", one for me.";
    }
}
