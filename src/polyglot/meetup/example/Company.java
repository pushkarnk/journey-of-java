package polyglot.meetup.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	
	ArrayList<Employee> employees = new ArrayList<>();
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	/* Employee-bonus map*/
	public HashMap<Employee,Double> getEmployeeBonuses() {
		HashMap<Employee,Double> bonuses = new HashMap<>();
		for (Employee e :  employees ) {
			double bonus = e.getBonus((salary, rating) ->salary * 0.2 * rating );
			bonuses.put(e, bonus);
		}
		return bonuses;
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
}
