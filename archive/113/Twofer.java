class Twofer {
    String twofer(String name) {
        String sentence;
        if(name!=null){
            sentence = "One for "+name+", one for me.";
        }
        else{
            sentence = "One for you, one for me.";
        }
        return sentence;
    }
}