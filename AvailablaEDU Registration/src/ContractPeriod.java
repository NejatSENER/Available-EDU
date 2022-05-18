import java.io.Serializable;

public class ContractPeriod implements Serializable{

	private String startDate;
	private String endDate;
	
	public ContractPeriod(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	// Getter - Setter
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ContractPeriod [startDate=" + startDate + 
				", endDate=" + endDate + 
				"]";
	}
	
	
	

}
