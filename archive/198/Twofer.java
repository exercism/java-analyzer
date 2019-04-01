class Twofer {
    String twofer(String name) {
        String x = name;

        if (name == null){
            return "One for you, one for me.";
        }

        return "One for "+x+", one for me.";

    }
}
