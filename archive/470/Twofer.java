class Twofer {
    String twofer(String name) {

        StringBuilder stringBuilder= new StringBuilder();
        if(name==null){
            stringBuilder.append("you");
        }
        else
            stringBuilder.append(name);
        return("One for "+stringBuilder.toString()+", one for me.");
    }
}
