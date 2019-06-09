package composite;

import java.util.ArrayList;
import java.util.List;

//this pattern can contain never ending groups
//allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects ex. File system
/**
 * 				root
 * 		  Left			Right
 *	Left     Right	Left	Right
 *.....................
 */
public class Composite implements Employee {
	private List<Employee> employeeList = new ArrayList<Employee>();

	@Override
	public void showEmployeeDetails() {
		for (Employee emp : employeeList) {
			emp.showEmployeeDetails();
		}
	}

	public void addEmployee(Employee emp) {
		employeeList.add(emp);
	}

	public void removeEmployee(Employee emp) {
		employeeList.remove(emp);
	}
}
