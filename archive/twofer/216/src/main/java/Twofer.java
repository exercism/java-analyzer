class Twofer {
    String twofer(String name) {
       if(name != null){
           System.out.println("one for"+name+", one for me.");
           return "One for "+name+", one for me.";
       }
       return "One for you, one for me.";
    }
}
