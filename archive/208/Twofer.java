class Twofer {
    String twofer(String name) {
        if(name == ""){
            return "One for you, one for me";
        }
        return "One for "+name+", one for me";
    }
    public static void main(String[] args){
        Twofer twoFer = new Twofer();
        System.out.println(twoFer.twofer(""));
    }
}
