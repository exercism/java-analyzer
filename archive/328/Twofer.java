class Twofer {
    String twofer(String name) {
        if ((name.isEmpty()) || (name==null))
            throw new UnsupportedOperationException("One for you, one for me.");
        else
            throw new UnsupportedOperationException("One for "+name+", one for me.");
    }
}
