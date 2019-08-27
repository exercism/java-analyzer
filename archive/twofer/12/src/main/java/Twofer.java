class Twofer {

    public Twofer(){  }

    public String twofer(String name) {
        if(name == null || name.equals(null) ){
            return "One for you, one for me.";
        }else{
            return "One for "+name+", one for me.";
        }
    }
}
