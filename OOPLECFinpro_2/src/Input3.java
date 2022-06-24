import java.util.*;

public class Input3 {
	
	Scanner sc = new Scanner(System.in);
	private MotorcycleController controller = new MotorcycleController();
	private Motorcycle model = new Motorcycle(0, "", "", "", 0, 0);

	public void update() {
		String stringInput;
		int intInput = -1;
		
		System.out.print("Input the bike's ID: ");
		do {
			try {
				intInput = sc.nextInt();
				model.setId(intInput);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Please input the correct ID!");
			}
			sc.nextLine();
		} while (intInput < 0);

		System.out.print("Input the bike's name: ");
		stringInput = sc.nextLine();
		model.setName(stringInput);

		System.out.print("Input the bike's brand: ");
		stringInput = sc.nextLine();
		model.setBrand(stringInput);

		System.out.print("Input the bike's color: ");
		stringInput = sc.nextLine();
		model.setColor(stringInput);

		intInput = -1;
		do {
			System.out.print("Input the bike's cc: ");
			try {
				intInput = sc.nextInt();
				model.setCc(intInput);
			} catch (Exception e) {
				// TODO: handle exception
				intInput = -1;
			}
			sc.nextLine();

		} while (intInput < 1);

		intInput = -1;
		do {
			System.out.print("Input the bike's price: ");
			try {
				intInput = sc.nextInt();
				model.setPrice(intInput);
			} catch (Exception e) {
				// TODO: handle exception
				intInput = -1;
			}
			sc.nextLine();
		} while (intInput < 1);
		
		controller.updateMotorcycle(model.getId(), model.getName(), model.getBrand(), model.getColor(), model.getCc(), model.getPrice());
		
	}
	
}
