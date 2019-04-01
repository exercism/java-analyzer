class Twofer {
    String twofer(String name) {
        String Alice = "Alice";
        String Bob = "Bob";
        if(name == Alice){
            return "One for"+ Alice+", one for me.";
        }
        else if(name == Bob){
            return "One for"+Bob+", one for me.";
        }
        else{
            return "One for"+" you"+", one for me.";
        }
    }
}
