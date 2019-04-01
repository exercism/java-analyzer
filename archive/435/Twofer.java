class Twofer {
    String twofer(String name) {
        if(name == "" || name == null){
            name = "you";
        }
        return "One for " + name + ", one for me.";
    }
}
