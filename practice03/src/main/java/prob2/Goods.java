package prob2;

public class Goods {
	private String name;
	private int price;
	private int stock;

	public Goods(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void printInfo() {
		System.out.println(name + "(가격:" + price + "원)이 " + stock + "개 입고 되었습니다.");
	}

}
