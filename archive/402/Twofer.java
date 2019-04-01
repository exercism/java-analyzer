import org.apache.commons.lang3.StringUtils;

class Twofer {
	
    String twofer(String name) {
    	
       if(StringUtils.isBlank(name)) {
    	   return "One for you, one for me.";
       }
       else {
    	   return "One for " + name + ", one for me.";
       }
    }
    
}
