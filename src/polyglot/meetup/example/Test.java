package polyglot.meetup.example;

import polyglot.meetup.example.Employee.Sex;

public class Test {

	Company c;
	
	public Test() {
		c = new Company();
		c.addEmployee(new Employee("Kevin", "Nick", 34, Employee.Sex.MALE, 10000,4));
		c.addEmployee(new Employee("Jessica", "Nick", 23, Employee.Sex.FEMALE, 80000,3));
		c.addEmployee(new Employee("Oliver", "Paresh", 38, Employee.Sex.MALE,78000,1));
		c.addEmployee(new Employee("Julia", "Paresh", 39, Employee.Sex.FEMALE,90000,4));
		c.addEmployee(new Employee("Neha", "Steve", 31, Employee.Sex.FEMALE,88000,3));
		c.addEmployee(new Employee("Ameer", "Steve", 24, Employee.Sex.MALE,45000,3));
		c.addEmployee(new Employee("Kate", "Larry", 41, Employee.Sex.FEMALE,34000,2));
		c.addEmployee(new Employee("Paul", "Larry", 24, Employee.Sex.MALE, 89000,2));
		c.addEmployee(new Employee("Nicole", "Satya", 43, Employee.Sex.FEMALE, 109000,1));
		c.addEmployee(new Employee("Cathy", "Satya", 48, Employee.Sex.FEMALE, 89000,4));	
	}
	
	
	public double averageBonus() {
		return c.getEmployeeBonuses().values()
				.stream()
				.mapToDouble(Double::doubleValue)
				.average()
				.getAsDouble();
	}
	
	private boolean isManagerNameFamous(String name) {
		switch(name) {
		case "Larry":
		case "Steve":
		case "Satya" : 
			return true;
		default: 
			return false;
		}
	}
	/* Find the maximum salary of a female employee who is in her 40s and reports to Larry, Satya or Steve */
	public double runQuery() {
		return c.getEmployees().stream()
						.filter(e -> e.age() >= 40)
						.filter(e -> e.sex() == Sex.FEMALE)
						.filter(e -> isManagerNameFamous(e.managerName()))
						.map(e -> e.getSalary())
						.mapToDouble(Double::doubleValue)
						.max().getAsDouble();
	}
	
	public static void main(String [] args) {
		Test t = new Test();
		System.out.println("Average bonus is      = " + t.averageBonus());
		System.out.println("Highest paid female = " + t.runQuery());
	}
}
