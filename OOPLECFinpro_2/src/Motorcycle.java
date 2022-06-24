public class Motorcycle {

	private int id;
    private String name;
    private String brand;
    private String color;
    private int cc;
    private int price;

    public Motorcycle(int id, String name, String brand, String color, int cc, int price) {
    	this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.cc = cc;
        this.price = price;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCc() {
        return this.cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
