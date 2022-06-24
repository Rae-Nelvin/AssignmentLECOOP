package entity;

public class Transaction {
	private String TransactionID;
	private String CustomerName;
	private String ProductName;
	private String ShippingName;
	private int Quantity;
	private int TotalPrice;
	private String TransactionDate;
	
	public Transaction(String transactionID, String customerName, String productName, String shippingName, int quantity,
			int totalPrice, String transactionDate) {
		super();
		TransactionID = transactionID;
		CustomerName = customerName;
		ProductName = productName;
		ShippingName = shippingName;
		Quantity = quantity;
		TotalPrice = totalPrice;
		TransactionDate = transactionDate;
	}
	
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getShippingName() {
		return ShippingName;
	}
	public void setShippingName(String shippingName) {
		ShippingName = shippingName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transaction [TransactionID=" + TransactionID + ", CustomerName=" + CustomerName + ", ProductName="
				+ ProductName + ", ShippingName=" + ShippingName + ", Quantity=" + Quantity + ", TotalPrice="
				+ TotalPrice + ", TransactionDate=" + TransactionDate + "]";
	}
	
	
	
}
