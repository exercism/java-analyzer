import java.util.Objects;

class Twofer {
    String twofer(String name) {
        if(Objects.isNull(name) || name.isEmpty()){
            return "One for you, one for me.";
        }else{
            return "One for "+ name +", one for me.";
        }
    }

}
