package chapter03;

public class Goods2 {
	public String name;		// 모든 접근이 가능
	protected int price;	// 같은 패키지 + 자식 클래스
	private int countStock;	// 같은 패키지(default)
	int countSold;

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

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

}
