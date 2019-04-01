class Twofer {
    private static final String ONE_FOR = "One for ";
    private static final String YOU = "you";
    private static final String ONE_FOR_ME = ", one for me.";

    String twofer(String name) {
        if(name == null) {
            name = YOU;
        }
        return ONE_FOR + name + ONE_FOR_ME;
    }
}
