class Twofer {
    String twofer(String name) {
        String result;
        if (name == null) {
            result = ("One for you, one for me.");
        } else {
            result = ("One for " + name + ", one for me.");
        }
        System.out.println(result);
        return result;

    }
}

class Execute {
    public static void main(String[] args) {
        Twofer t = new Twofer();
        t.twofer(null);

    }

}