package TreePackage;

public class Variable {
	
	private String name;
	private double value;
	
	public Variable(String name) {
		this.name = name;
	}
	
	public Variable(String name, double value) {
		this.name = name;
		this.setValue(value);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
