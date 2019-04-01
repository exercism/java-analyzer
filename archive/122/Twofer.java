class Twofer {
    String twofer(String name) {
        String text=", one for me.";
        if(name==null || name=="")  text="One for you"+text;
        else text= "One for "+name+text;
        return text;
    }
}
