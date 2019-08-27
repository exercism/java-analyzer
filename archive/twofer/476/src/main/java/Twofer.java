class Twofer {
    private String statment= "One for you, one for me.";
    String twofer(String name) {
        if(name!=null) {
            return statment.replace("you", name);
        }
        else{return statment;}
    }
}
