class Twofer {
    String twofer(String name) {
        // throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        if (name == null){
            return "One for you, one for me.";
        }else{
            return "One for "+name+", one for me.";
        }
    }
}
