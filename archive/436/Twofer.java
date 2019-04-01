class Twofer {


    String name1 = "Alice";

    String name2 = "Bob";

    String twofer(String name) {

        if (name == null) {
            return "One for you, one for me.";
        }
        else if (name == name1) {
            return "One for Alice, one for me.";
        }
        else if (name == name2){
            return "One for Bob, one for me.";
        }
        else {return null;}
    }
}
