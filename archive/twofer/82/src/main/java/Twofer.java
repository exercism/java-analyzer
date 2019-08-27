class Twofer {
    String twofer(String name) {
        
        if (name == null) {
            name = "you";
        }

        String format = "One for %s, one for me.";
        String response = String.format(format, name);

        return response;
    }
}
