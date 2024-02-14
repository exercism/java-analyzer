class UnknownExercise {
	int calculate() {
		return 42;
	}

	public static void main(String[] args) {
		var exercise = new UnknownExercise();
		System.out.println(exercise.calculate());
	}
}
