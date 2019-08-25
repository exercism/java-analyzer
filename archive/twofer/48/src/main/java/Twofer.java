class Twofer {
    String twofer(String name) {
        String onefor = "you"; 

        if (name != null){
            onefor = name;
        }
        
        return String.format("One for %s, one for me.", onefor);
    }
}
