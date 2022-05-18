import java.io.Serializable;

public class TeacherData extends Registration implements Serializable{
	
	public TeacherData(String firstName, String lastName, String birthDay, String gender, int phone) {
		super(firstName, lastName, birthDay, gender, phone);
	}

	@Override
	public String toString() {
		return "TeacherData [getFirstName()=" + getFirstName() + 
				", getLastName()=" + getLastName() + 
				", getBirthDay()=" + getBirthDay() + 
				", getGender()=" + getGender() + 
				", getPhone()=" + getPhone() + 
				"]";
	}

}
