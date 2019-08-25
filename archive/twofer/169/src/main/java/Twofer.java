class Twofer 
{
    String twofer(String name) {

        String input;

        if (name == null)
        {
            input = "One for you, one for me.";
        }
        else
        {
            input = "One for " + name + ", one for me.";
        }

        return input;
    }
}
