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
		employees.forEach( e -> bonuses.put(e, e.getBonus((salary, rating) ->salary * 0.2 * rating )));
		return bonuses;
	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
}
