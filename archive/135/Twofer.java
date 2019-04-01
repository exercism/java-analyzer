class Twofer {
    String twofer(String name) {

        String phrase;

        if(name == null){
          phrase = "One for you, one for me.";
        }else{
          phrase = "One for " + name + ", one for me.";
        }

        return phrase;
    }
}
