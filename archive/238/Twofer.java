class Twofer {
    String twofer(String name) {
        String nameToUse;
        if(name == null){
            nameToUse = "you";
        }else{
            nameToUse = name;
        }

        return "One for " + nameToUse + ", one for me.";
    }
}
