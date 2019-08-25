class Twofer {
    String twofer(String name) {
        String val = "you";
        if(name != null && name.length()>0){
            val = name;
        }

        return String.format("One for %s, one for me.", val);
    }
}
