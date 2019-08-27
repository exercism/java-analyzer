class Twofer {
    String twofer(String name) {
        String s = "you";

        if ((name!=null)&&(!name.isEmpty()))
          s = name;
        return "One for "+s+", one for me.";
    }

}
