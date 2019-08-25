class Twofer {
    String twofer(String name) {
        try{
            if(name.length()>1){
                return "One for " +  name + ", one for me.";

            }
            else{
                return "error";
            }
        }catch(NullPointerException e){
            return "One for you, one for me.";
        }
    }
}
