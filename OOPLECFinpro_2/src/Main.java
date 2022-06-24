import java.util.*;

public class Main {

	Connect con = Connect.getConnection();
	Scanner sc = new Scanner(System.in);
	MotorcycleController controller = new MotorcycleController();

	public Main() {
		// TODO Auto-generated constructor stub
		int inp = -1;
		boolean isRun = true;

		do {

			do {

				showMenu();
				System.out.print(">> ");
				try {
					inp = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					inp = -1;
				}
				sc.nextLine();

				switch (inp) {
					case 1:
						Input1 input1 = new Input1();
						input1.input();
						System.out.println("Press enter to continue.");
						sc.nextLine();
						break;
					case 2:
						controller.showMotorcycle();
						System.out.println("Press enter to continue.");
						sc.nextLine();
						break;
					case 3:
						controller.showMotorcycle();
						Input3 input3 = new Input3();
						input3.update();
						System.out.println("Press enter to continue.");
						sc.nextLine();
						break;
					case 4:
						isRun = !isRun;
						break;

					default:
						break;
				}

			} while (inp < 1 && inp > 4);

		} while (isRun);
	}

	public void showMenu() {
		System.out.println("Welcome to Big Bike Motorcycle");
		System.out.println("==============================");
		System.out.println();
		System.out.println("Choose an option");
		System.out.println("1. Add new ride");
		System.out.println("2. Show all available rides");
		System.out.println("3. Update a ride");
		System.out.println("4. Close");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
