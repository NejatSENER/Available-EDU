
public abstract class Classes {
	
	String className;
	String classType;
	int price;
	
	public Classes(String className, String classType, int price) {
		this.className   = className;
		this.classType   = classType;
		this.price       = price;
	}
	
	// Getter - Setter
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getClassType() {
		return classType;
	}
	
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
}
