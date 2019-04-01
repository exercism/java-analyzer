class Twofer {
    String twofer(String name) {
        final String ONE_FOR_NAME = "One for ";
        final String ONE_FOR_ME = ", one for me.";
        if (name != null && !name.isEmpty()) {
            return ONE_FOR_NAME + name + ONE_FOR_ME;
        }
        return ONE_FOR_NAME +  "you" + ONE_FOR_ME;
    }
}
