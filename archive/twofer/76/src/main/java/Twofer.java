class Twofer
{
	String twofer(final String name)
	{
		return String.format("One for %s, one for me.", (name == null || name.isEmpty()) ? "you" : name);
	}
}
