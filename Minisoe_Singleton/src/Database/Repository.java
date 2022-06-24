package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Customer;
import entity.Product;
import entity.Shipping;
import entity.Transaction;

public class Repository {
	//singleton design pattern
	private static Repository instance;
	private Connect connect;
	
	private Repository() {
		connect=Connect.getConnection();
	}
	
	public static Repository getInstance() {
		if (instance==null) instance = new Repository();
		return instance;
	}
	
	public String generateNewTransactionID() {
		String nextID ="";
		try {
			String query = "SELECT `TransactionID` FROM `transaction` \r\n" + 
					"ORDER BY `TransactionID` DESC LIMIT 1";
			ResultSet res = connect.executeQuery(query);
			if(res.next()) {
				nextID=res.getString("TransactionID");
				Integer idInt = Integer.parseInt(nextID.substring(2))+1;
				nextID= String.format("TR%03d", idInt);
			}else {
				nextID = "TR001";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextID;
	}
	
	public boolean checkingExist(String id, String cName,String tName) {
		try {
			String query = String.format("SELECT null FROM `%s` WHERE `%s`= '%s'", tName,cName,id);
			ResultSet res = connect.executeQuery(query);
			if (res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your input is Wrong! Please Try Again...");
		return false;
	}
	
	public ArrayList<Shipping> getShippings(){
		ArrayList<Shipping> shippings = new ArrayList<>();
		try {
			String query ="SELECT * FROM `shipping`";
			ResultSet res=connect.executeQuery(query);
			String id,name;
			while(res.next()) {
				id =res.getString("ShippingID");
				name =res.getString("ShippingName");
				shippings.add(new Shipping(id, name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shippings;
	}
	
	public ArrayList<Product> getProducts(){
		ArrayList<Product> products= new ArrayList<>();
		try {
			String query="SELECT `ProductID`, `ProductTypeName`, `ProductName`, `Price` FROM `product` p\r\n" + 
					"JOIN producttype pt On p.ProductTypeID = pt.ProductTypeID";
			ResultSet res=connect.executeQuery(query);
			String id,name,type;
			Integer price;
			while(res.next()) {
				id =res.getString("ProductID");
				name =res.getString("ProductName");
				type =res.getString("ProductTypeName");
				price =res.getInt("Price");
				products.add(new Product(id, name, type, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			String query = "SELECT `CustomerID`, `CustomerName`, `CustomerGender`, "
					+ "`CustomerAddress`, `CustomerEmail`, `CustomerAge` FROM `customer`";
			ResultSet res= connect.executeQuery(query);
			String customerID, customerName, customerGender, customerAddress, customerEmail; int customerAge;
			while(res.next()) {
				customerID = res.getString("CustomerID");
				customerName = res.getString("CustomerName");
				customerGender= res.getString("CustomerGender");
				customerAddress= res.getString("CustomerAddress");
				customerEmail = res.getString("CustomerEmail");
				customerAge = res.getInt("CustomerAge");
				
				if (customerAddress==null)customerAddress="-";
				
				customers.add(new Customer(customerID, customerName, customerGender, customerAddress, customerEmail, customerAge));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public ArrayList<Transaction> getTransactions(){
		ArrayList<Transaction> transactions = new ArrayList<>();
		try {
			String query = "SELECT `TransactionID`, c.CustomerName, p.ProductName, s.ShippingName,t.Quantity,(p.Price*t.Quantity) AS `TotalPrice`, `TransactionDate` \r\n" + 
					"FROM `transaction` t\r\n " + 
					"JOIN customer c ON c.CustomerID=t.CustomerID\r\n " + 
					"JOIN product p ON p.ProductID=t.ProductID\r\n " + 
					"JOIN shipping s ON s.ShippingID=t.ShippingID ";
			ResultSet res = connect.executeQuery(query);
			String TransactionID, CustomerName, ProductName, ShippingName, TransactionDate;
			Integer Quantity, TotalPrice;
			while(res.next()) {
				TransactionID=res.getString("TransactionID");
				CustomerName=res.getString("CustomerName");
				ProductName=res.getString("ProductName");
				ShippingName=res.getString("ShippingName");
				Quantity=res.getInt("Quantity");
				TotalPrice=res.getInt("TotalPrice");
				TransactionDate=res.getString("TransactionDate");
				transactions.add(new Transaction(TransactionID, CustomerName, ProductName, ShippingName, Quantity, TotalPrice, TransactionDate));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
	}

	public void InsertTransaction(String customerID, String productID, String shippingID, Integer quantity,
			String transactionDate) {
		// TODO Auto-generated method stub
		String query = String.format("INSERT INTO `transaction`(`TransactionID`, `CustomerID`, `ProductID`, "
				+ "`ShippingID`, `Quantity`, `TransactionDate`) VALUES \r\n" + 
				"('%s','%s','%s','%s','%d','%s')", generateNewTransactionID(),customerID,productID,shippingID,quantity,transactionDate);
		connect.executeUpdate(query);
	}

	public void deleteProduct(String productID) {
		// TODO Auto-generated method stub
		String query=String.format("DELETE FROM `product` \r\n" + 
				"WHERE ProductID = '%s' ", productID);
		connect.executeUpdate(query);
	}

	public void updateProduct(String productID, Integer price) {
		// TODO Auto-generated method stub
		String query =String.format("UPDATE `product` SET `Price`='%d' WHERE ProductID = '%s'", price,productID);
		connect.executeUpdate(query); 
	}

	public void deleteTransaction(String transactionID) {
		// TODO Auto-generated method stub
		String query = String.format("DELETE FROM `transaction` WHERE TransactionID = '%s'", transactionID);
		connect.executeUpdate(query);
	}

}
