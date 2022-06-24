import java.util.*;

public class Input1 {

	private MotorcycleController controller = new MotorcycleController();
	private Motorcycle model = new Motorcycle(0, "", "", "", 0, 0);
	private Scanner sc = new Scanner(System.in);

	public void input() {

		String stringInput;
		int intInput = -1;

		System.out.print("Input the bike's name: ");
		stringInput = sc.nextLine();
		model.setName(stringInput);

		System.out.print("Input the bike's brand: ");
		stringInput = sc.nextLine();
		model.setBrand(stringInput);

		System.out.print("Input the bike's color: ");
		stringInput = sc.nextLine();
		model.setColor(stringInput);

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

		controller.addMotorcycle(model.getName(), model.getBrand(), model.getColor(), model.getCc(), model.getPrice());

	}

}
