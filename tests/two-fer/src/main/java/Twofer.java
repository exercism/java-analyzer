class Twofer {
    public String twofer(String name) {
        if (name == null) {
            return "Two for you, two for me.";
        }

        return String.format("Two for %s, two for me.", name);
    }

    public static void main(String[] args) {
        TwoFer twoFer = new TwoFer();
        System.out.println(twoFer.twofer(null));
        System.out.println(twoFer.twofer("John"));
    }
}
