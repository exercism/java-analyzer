class Twofer {
    String twofer(String name) {
        String input = name;
        String expected = "";
         
        if (input == null){
            return "One for you, one for me.";
        }
         if (input.equals(name)){
            expected = "One for "+ name + ", one for me.";
        }
        return expected;
         
            
         

    }
}
