import java.io.Serializable;

public class StudentData extends Registration implements Serializable{
	
	String membership;
	
	public StudentData(String firstName, String lastName, String birthDay, String gender, int phone, String membership) {
		super(firstName, lastName, birthDay, gender, phone);
		this.membership = membership;
	}	

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		return "StudentData [membership=" + membership + 
				", getFirstName()=" + getFirstName() + 
				", getLastName()=" + getLastName() + 
				", getBirthDay()=" + getBirthDay() + 
				", getGender()=" + getGender() + 
				", getPhone()=" + getPhone() + 
				", getMembership()=" + getMembership() +
				"]";
	}
	
	
}
