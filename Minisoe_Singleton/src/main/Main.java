package main;

import java.time.LocalDate;
import java.util.Scanner;

import Database.Repository;
import entity.Customer;
import entity.Product;
import entity.Shipping;
import entity.Transaction;

public class Main {
	private Scanner scan;
	private Repository repo;
	public Main() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		repo = Repository.getInstance();
		
		int choose=0;
		
		while (true) {
			
			System.out.println("Welcome to Minisoe!");
			System.out.println("1. Buy Product");
			System.out.println("2. Change Product");
			System.out.println("3. View All Transactions");
			System.out.println("4. Delete Transactions");
			System.out.println("5. Exit");
			
			choose = scan.nextInt();scan.nextLine();
			
			switch (choose) {
			case 1:
				buyProduct();
				break;
			case 2:
				changeProduct();
				break;
			case 3:
				viewTrans();
				break;
			case 4:
				deleteTrans();
				break;
			case 5:
				System.out.println("Thankyou, See ya!");
				System.exit(0);
				break;
			
			}
		}
	}

	private void changeProduct() {
		// TODO Auto-generated method stub
		String c;
		do {
			System.out.println("Update | Delete [Case Insensitive] >> ");
			c =scan.nextLine();
		} while (!(c.equalsIgnoreCase("DELETE")||c.equalsIgnoreCase("UPDATE")));
		
		if(c.equalsIgnoreCase("DELETE")) {
			for(Product p : repo.getProducts()) {
				System.out.println(String.format("| %-5s | %-30s | %-7s | %-10d |", p.getId(),p.getName(),
						p.getType(),p.getPrice()));
			}
			
			String ProductID;
			do {
				System.out.println("Input the ProductID you want to delete : ");
				ProductID=scan.nextLine();
			} while (!repo.checkingExist(ProductID, "ProductID", "product"));
			
			repo.deleteProduct(ProductID);
			System.out.println("The product has been deleted...");
			
		}else if(c.equalsIgnoreCase("UPDATE")) {
			for(Product p : repo.getProducts()) {
				System.out.println(String.format("| %-5s | %-30s | %-7s | %-10d |", p.getId(),p.getName(),
						p.getType(),p.getPrice()));
			}
			
			String ProductID;
			do {
				System.out.println("Input the ProductID you want to Update Price : ");
				ProductID=scan.nextLine();
			} while (!repo.checkingExist(ProductID, "ProductID", "product"));
			
			Integer price;
			do {
				System.out.println("Update Price to : ");
				price = scan.nextInt();scan.nextLine();
			} while (!(price>1));
			
			repo.updateProduct(ProductID,price);
			System.out.println("The product price has been updated...");
		}
	}

	private void deleteTrans() {
		// TODO Auto-generated method stub
		System.out.println("================================================TRANSACTION LIST================================================");
		for (Transaction transaction : repo.getTransactions()) {
			System.out.println(String.format("| %-5s | %-20s | %-25s | %-16s | %-4d | %-10d | %-10s |", 
					transaction.getTransactionID(), transaction.getCustomerName(),transaction.getProductName(),
					transaction.getShippingName(),transaction.getQuantity(),transaction.getTotalPrice(),
					transaction.getTransactionDate()));
		}
		
		String TransactionID;
		do {
			System.out.println("Input the TransactionID you want to delete : ");
			TransactionID=scan.nextLine();
		} while (!repo.checkingExist(TransactionID, "TransactionID", "transaction"));
		repo.deleteTransaction(TransactionID);
		System.out.println("Transaction has been deleted..");
	}

	private void buyProduct() {
		// TODO Auto-generated method stub
		for(Customer c : repo.getCustomers()) {
			System.out.println(String.format("| %-5s | %-20s | %-8s | %-25s | %-30s | %-3d |", c.getCustomerID(),
					c.getCustomerName(),c.getCustomerGender(),c.getCustomerAddress(),c.getCustomerEmail(),
					c.getCustomerAge()));
		}
		
		String CustomerID;
		do {
			System.out.println("Who are you?");
			System.out.println("Input your CustomerID : ");
			CustomerID =scan.nextLine();
		} while (!repo.checkingExist(CustomerID, "CustomerID", "customer"));
		
		for(Product p : repo.getProducts()) {
			System.out.println(String.format("| %-5s | %-30s | %-7s | %-10d |", p.getId(),p.getName(),
					p.getType(),p.getPrice()));
		}
		
		String ProductID;
		do {
			System.out.println("Input the ProductID you want to buy : ");
			ProductID=scan.nextLine();
		} while (!repo.checkingExist(ProductID, "ProductID", "product"));
		
		for(Shipping s : repo.getShippings()) {
			System.out.println(String.format("| %-5s | %-30s |", s.getId(),s.getName()));
		}
		
		String ShippingID;
		do {
			System.out.println("Please input the ShippingID : ");
			ShippingID=scan.nextLine();
		} while (!repo.checkingExist(ShippingID, "ShippingID", "shipping"));
		
		Integer Quantity;
		do {
			System.out.println("Input Quantity : ");
			Quantity=scan.nextInt();scan.nextLine();
		} while (Quantity<1||Quantity>2000);
		
		String TransactionDate = LocalDate.now().toString();
		
		repo.InsertTransaction(CustomerID,ProductID,ShippingID,Quantity,TransactionDate);
		System.out.println("Transaction has been successful");
	}

	private void viewTrans() {
		// TODO Auto-generated method stub
		System.out.println("================================================TRANSACTION LIST================================================");
		for (Transaction transaction : repo.getTransactions()) {
			System.out.println(String.format("| %-5s | %-20s | %-25s | %-16s | %-4d | %-10d | %-10s |", 
					transaction.getTransactionID(), transaction.getCustomerName(),transaction.getProductName(),
					transaction.getShippingName(),transaction.getQuantity(),transaction.getTotalPrice(),
					transaction.getTransactionDate()));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
