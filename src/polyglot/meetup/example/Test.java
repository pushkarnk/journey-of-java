package polyglot.meetup.example;

import java.util.ArrayList;

public class Test {

	Company c;
	public Test() {
		c = new Company();
		c.addEmployee(new Employee("Kevin", "Nick", 34, Employee.MALE, 10000,4));
		c.addEmployee(new Employee("Jessica", "Nick", 23, Employee.FEMALE, 80000,3));
		c.addEmployee(new Employee("Oliver", "Paresh", 38, Employee.MALE,78000,1));
		c.addEmployee(new Employee("Julia", "Paresh", 39, Employee.FEMALE,90000,4));
		c.addEmployee(new Employee("Neha", "Steve", 31, Employee.FEMALE,88000,3));
		c.addEmployee(new Employee("Ameer", "Steve", 24, Employee.MALE,45000,3));
		c.addEmployee(new Employee("Kate", "Larry", 41, Employee.FEMALE,34000,2));
		c.addEmployee(new Employee("Paul", "Larry", 24, Employee.MALE, 89000,2));
		c.addEmployee(new Employee("Nicole", "Satya", 43, Employee.FEMALE, 109000,1));
		c.addEmployee(new Employee("Cathy", "Satya", 48, Employee.FEMALE, 89000,4));	
	}
	
	
	public double averageBonus() {
		Object [] bonuses = c.getEmployeeBonuses().values().toArray();
		double sum = 0;
		for(int i = 0; i < bonuses.length; i++) {
			sum += ((Double)(bonuses[i])).doubleValue();
		}
		return sum/bonuses.length;
	}
	
	private boolean isManagerNameFamous(String name) {
		if(name.equals("Larry") || name.equals("Satya") || name.equals("Steve"))
				return true;
		return false;
	}
	/* Find the maximum salary of a female employee who is in her 40s and reports to Larry, Satya or Steve */
	public double runQuery() {
		ArrayList employees = c.getEmployees();
		double max = 0.0;
		for (int i = 0; i<employees.size(); i++) {
			Employee e = (Employee)(employees.get(i));
			if (e.sex() == Employee.FEMALE && e.age() >= 40 && isManagerNameFamous(e.managerName())) {
				double salary = e.getSalary();
				if(salary > max)
					max = salary;
			}
		}
		return max;
	}
	
	public static void main(String [] args) {
		Test t = new Test();
		System.out.println("Average bonus is = " + t.averageBonus());
		System.out.println("Highest paid female = " + t.runQuery());
	}
}
