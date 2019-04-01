class Twofer {
    String twofer(String name) {
        if (checkString(name))
            return "One for "+name+", one for me.";
        else
            return "One for you, one for me.";

    }
    boolean checkString (String input)
    {
        if (input==null || input.isEmpty())
            return false;
        else
            return true;
    }


}
