class Twofer {
    String twofer(String name)
    {
        String returnStr;
        if (name != null)
        {
            return "One for " + name + ", one for me.";
        }
        else
        {
            return "One for you, one for me.";
        }
    }
}
