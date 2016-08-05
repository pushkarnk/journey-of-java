package polyglot.meetup.example;

public class Employee {

	public enum Sex {
		FEMALE,MALE
	}
	
	private String name;
	private int age;
	private double monthlySalary;
	private Sex sex;
	private String managerName;
	private int performanceRating;
	
	public Employee(String name, String managerName, int age, Sex sex, double salary, int performanceRating) {
		this.name = name;
		this.managerName = managerName;
		this.sex = sex;
		this.age = age;
		this.monthlySalary = salary;
		this.performanceRating = performanceRating;
	}
	
	public double getBonus(BonusCalculator calculator) {
		try {
			return calculator.calculate(monthlySalary, performanceRating);
		} catch (LowRatingException ire) {
			System.err.println("Rating very low");
			return 0;
		}  catch(HighSalaryException ise) {
			System.err.println("Salary very high");
			return 0;
		}
	}
	
	public Sex sex() {
		return sex;
	}
	
	public int age() {
		return age;
	}
	
	public String managerName() {
		return managerName;
	}
	
	public String toString() {
		return name;
	}
	
	public double getSalary() {
		return monthlySalary;
	}
}


