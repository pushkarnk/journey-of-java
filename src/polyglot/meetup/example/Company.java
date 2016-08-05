package polyglot.meetup.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}

	BonusCalculator bonusCalc = new BonusCalculator() {
		public double calculate(double salary, int rating) {
			return salary * 0.2 * rating;
		}
	};
	
	/* Employee-bonus map*/
	public HashMap<Employee,Double> getEmployeeBonuses() {
		HashMap<Employee,Double> bonuses = new HashMap<Employee,Double>();
		for (int i = 0; i < employees.size(); i++) {
			Employee e = employees.get(i);
			double bonus = e.getBonus(bonusCalc);
			bonuses.put(e, Double.valueOf(bonus));
		}
		return bonuses;
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
}
