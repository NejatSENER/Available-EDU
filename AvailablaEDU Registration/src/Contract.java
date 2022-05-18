import java.io.Serializable;

public class Contract implements Serializable{
	
	private int registryMoney = 50;
	private int registryProfit;
	private int numberOfLesson;
	private Registration registration;
	private ContractPeriod period;
	private String date;
	private int totalMoney;
	private String membershipType;
	
	
	public Contract(int numberOfLesson, Registration registration, ContractPeriod period, String date, String membershipType) {
		super();
		this.numberOfLesson = numberOfLesson;
		this.registration = registration;
		this.period = period;
		this.date = date;
		this.registryProfit = numberOfLesson * registryMoney;
		this.membershipType = membershipType;
	}
	
	public void setRegistryMoney(int registryMoney) {
		this.registryMoney = registryMoney;
	}
	
	public int getNumberOfLesson() {
		return numberOfLesson;
	}

	public void setNumberOfLesson(int numberOfLesson) {
		this.numberOfLesson = numberOfLesson;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public ContractPeriod getPeriod() {
		return period;
	}

	public void setPeriod(ContractPeriod period) {
		this.period = period;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getTotalMoney() {
		totalMoney = registryMoney;
		return totalMoney;		
	}
	
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public String getMembershipType() {
		return membershipType;
	}
	
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
	@Override
	public String toString() {
		return "Contract [numberOfLesson=" + numberOfLesson + 
				", registration=" + registration + 
				", period=" + period + 
				", date=" + date + 
				"]";
	}
	
	
}
