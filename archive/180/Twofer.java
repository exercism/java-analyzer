class Twofer {
    String twofer(String name) {
    	String _name;
        if (name == null || name.trim().length() == 0 )
        	_name="you";
        else
        	_name=name;
        
        return "One for " + _name +", one for me.";
    }
}
