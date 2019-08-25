class Twofer {

    public static void main(String[] args) {
        System.out.println(twofer("Cindy"));
    }

    public static String twofer(String name) {

        if (name.isEmpty()){
            return "One for you, one for me.";
        }else {
            return "One for " + name + ", one for me.";
        }
    }
}
