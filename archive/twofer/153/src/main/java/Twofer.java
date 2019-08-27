import java.util.Optional;

class Twofer {
    String twofer(Optional<String> name) {
    
        String result;
        
        if (name.isPresent()) {
        	result = "One for " + name.get() + ", one for me.";
        } else {
        	result = "One for you, one for me.";
        }
        return result;
    }
}
        
