package entity;

public class Customer {
	private String customerID;
	private String customerName;
	private String customerGender;
	private String customerAddress;
	private String customerEmail;
	private int customerAge;
	
	public Customer(String customerID, String customerName, String customerGender, String customerAddress,
			String customerEmail, int customerAge) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerAge = customerAge;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	
	
}
