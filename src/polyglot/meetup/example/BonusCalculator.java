package polyglot.meetup.example;

public interface BonusCalculator {
	
	public double calculate(double salary, int rating) throws LowRatingException, HighSalaryException;

}
