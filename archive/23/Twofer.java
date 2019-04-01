class Twofer {
    String twofer(String name) {
        if (name == null){
            name = "you";
        }
        String s = "One for " + name + ", one for me.";
        return s;
    }

}

