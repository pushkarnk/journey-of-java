package polyglot.meetup.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	
	ArrayList employees = new ArrayList();
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}

	BonusCalculator bonusCalc = new BonusCalculator() {
		public double calculate(double salary, int rating) {
			return salary * 0.2 * rating;
		}
	};
	
	/* Employee-bonus map*/
	public HashMap getEmployeeBonuses() {
		HashMap bonuses = new HashMap();
		for (int i = 0; i < employees.size(); i++) {
			Employee e = (Employee)(employees.get(i));
			double bonus = e.getBonus(bonusCalc);
			bonuses.put(e, Double.valueOf(bonus));
		}
		return bonuses;
	}
	
	public ArrayList getEmployees() {
		return employees;
	}
	
}
