class Twofer {
    String twofer(String name) 
	{
		String phrase;
      if ( name != null && !name.isEmpty())
	  {
		  phrase = "One for ";
		  phrase += name;
		  phrase += ", one for me.";
	  }
	  else 
	  {
		  phrase = "One for you, one for me.";
	  }
	  return phrase;
    }
}
