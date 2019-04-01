class Twofer {
    String twofer(String name) {
        //"One for "
        // + name + ", one for me" : return "One for you, one for me.";
        if(name != null) {
            return "One for " + name + ", one for me.";
        } else {
            return "One for you, one for me.";
        }

    }
}
