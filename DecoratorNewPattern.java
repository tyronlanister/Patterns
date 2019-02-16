abstract class Employee{
	
	abstract double getSalary();
	abstract String getDescription();
	
}

class Consultant extends Employee{

	@Override
	double getSalary() {
		return 70000;
	}
	
	String getDescription() {
		return "Consultant";
	}
	
}

class Manager extends Employee{

	@Override
	double getSalary() {
		return 80000;
	}
	
	String getDescription() {
		return "Manager";
	}
	
}


class Engineer extends Employee{

	@Override
	double getSalary() {
		return 60000;
	}
	
	String getDescription() {
		return "Engineer";
	}
	
}

abstract class EmployeeQualification extends Employee{
	
	protected Employee newEmployee;
	
	public EmployeeQualification(Employee employee) {
		this.newEmployee = employee;
	}
	
	double getSalary() {
		return newEmployee.getSalary();
	}
	
	String getDescription() {
		return newEmployee.getDescription();
	}
}

class WorkExperience extends EmployeeQualification{

	public WorkExperience(Employee employee) {
		super(employee);
		
	}
	
	double getSalary() {
		return newEmployee.getSalary() + 20000;
	}
	
	String getDescription() {
		return newEmployee.getDescription() + " , Work Experience";
	}
	
}

class EmployeeCertification extends EmployeeQualification{

	public EmployeeCertification(Employee employee) {
		super(employee);
		
	}
	
	double getSalary() {
		return newEmployee.getSalary() + 30000;
	}
	
	String getDescription() {
		return newEmployee.getDescription() + " , Employee Certification";
	}
	
}

public class DecoratorNewPattern{
	
	public static void main(String[] args) {
		
		Employee engineer = new Engineer();
		Employee consultant = new WorkExperience(new Consultant());
		Employee manager = new EmployeeCertification(new WorkExperience(new Manager()));
		
		System.out.println(engineer.getDescription() + " || " + engineer.getSalary());
		System.out.println(consultant.getDescription() + " || " + consultant.getSalary());
		System.out.println(manager.getDescription() + " || " + manager.getSalary());
	}
}



