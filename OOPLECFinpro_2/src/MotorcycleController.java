import java.sql.ResultSet;
import java.sql.SQLException;

public class MotorcycleController {
	
	Connect con = Connect.getConnection();

    public void addMotorcycle(String motorcycleName, String motorcycleBrand, String motorcycleColor, int motorcycleCC, int motorcyclePrice) {
		String query = String.format(
				"INSERT INTO `motorcycles`(`name`, `brand`, `color`, `cc`, `price`) VALUES ('%s', '%s', '%s', '%d' , '%d')",
				motorcycleName,
				motorcycleBrand, motorcycleColor, motorcycleCC, motorcyclePrice);
		con.executeUpdate(query);
    }
    
    public void showMotorcycle() {
    	String query = String.format("SELECT * FROM motorcycles");
    	ResultSet rs = con.executeQuery(query);
    	
        System.out.println(
                "| Motorcycle ID | Motorcycle Name | Motorcycle Brand | Motorcycle Color | Motorcycle CC | Motorcycle OTR Price |");
    	try {
    		while(rs.next()) {
    			Motorcycle model = new Motorcycle(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getString("color"), rs.getInt("cc"), rs.getInt("price"));
    			MotorcycleView view = new MotorcycleView();
    			view.printMotorcycleDetails(model.getId(), model.getName(), model.getBrand(), model.getColor(), model.getCc(), model.getPrice());
    		}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    };
    
    public void updateMotorcycle(int motorcycleID, String motorcycleName, String motorcycleBrand, String motorcycleColor, int motorcycleCC, int motorcyclePrice) {
    	String query = String.format(
				"UPDATE `motorcycles` SET `name` = '%s', `brand` = '%s', `color` = '%s', `cc` = '%d', `price` = '%d' WHERE `motorcycles`.`id` = %d",
				motorcycleName,
				motorcycleBrand, motorcycleColor, motorcycleCC, motorcyclePrice, motorcycleID);
		con.executeUpdate(query);
    }

}
