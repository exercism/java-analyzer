class Twofer {
    String twofer(String name) {
        String returnName;
        if (name == null) {
            returnName = "you";
        } else {
            returnName = name;
        }
        String outPutString = String.format("One for %s, one for me.", returnName);
        return outPutString;

    }
}
