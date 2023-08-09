package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		Goods2 camera = new Goods2();
		camera.name = "Nikon";
		camera.price = 500000;
		// camera.countStock = 10;
		camera.setCountStock(10);
		camera.countSold = 20;

		System.out.println("상품이름" + camera.name + "\n가격 : " + camera.price + "원\n재고 : " + camera.getCountStock()
				+ "개\n판매개수 : " + camera.countSold + "개");
		
	}

}
