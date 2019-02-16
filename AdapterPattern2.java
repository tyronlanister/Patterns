interface Students{
	public String getFullName();
	public int getAge();
	public String getContactNumber();
}

class UniversityStudent implements Students{

	private String fullName;
	private int age;
	private String phoneNumber;
	
	public void setFullName(String name) {
		this.fullName = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPhoneNumber(String number) {
		this.phoneNumber = number;
	}
	
	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return fullName;
		
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
		
	}

	@Override
	public String getContactNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
		
	}
	
}

class Person{
	
	private String NIC;
	private String firstName;
	private String lastName;
	private String dob;
	private String phoneNumber;
	
	public void setNIC(String nic) {
		this.NIC = nic;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDOB(String dob) {
		this.dob = dob;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getNIC() {
		return NIC;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
}

class PersonAdapter implements Students{

	private Person person;
	
	public PersonAdapter(Person newPerson) {
		person = newPerson;
	}
	
	
	@Override
	public String getFullName() {
		return person.getFirstName() + " " + person.getLastName();
	}

	@Override
	public int getAge() {
		return 1;

	}
	
	@Override
	public String getContactNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class AdapterPattern2 {

}
