class Twofer {
    public static String ONE_FOR_YOU = "One for you, one for me.";
    String twofer(String name) {
        if(name == null || "".equals(name)){
            return ONE_FOR_YOU;
        }
        return ONE_FOR_YOU.replace("you",name);
    }
}
