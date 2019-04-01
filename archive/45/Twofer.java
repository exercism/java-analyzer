class Twofer {
    String twofer(String name) {
        if("".equals(name)|| name == null){
            return "One for you, one for me.";
        }

        return "One for "+name+", one for me.";
    }
}
