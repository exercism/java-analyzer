class Twofer {
    String twofer(String name) {

        String result = "One for %s, one for me.";

        return (name == null || name.isEmpty()) ?
                String.format(result, "you") :
                String.format(result, name);

    }
}
