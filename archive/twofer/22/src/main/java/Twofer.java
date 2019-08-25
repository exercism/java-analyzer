
class Twofer {
    String twofer(String name) {
        if (null == name){
            name = "Bob";
        }
        return ("One for "+name+", one for me.");
    }
}