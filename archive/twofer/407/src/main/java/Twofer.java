class Twofer {
    String twofer(String name) {
        if(name == null)
            return new StringBuilder().append("One for you, one for me.").toString();
        return new StringBuilder().append("One for ").append(name).append(", one for me.").toString();
    }
}
