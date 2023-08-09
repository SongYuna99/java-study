package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.setName("Nikon");
		camera.setPrice(400000);
		camera.setCountStock(10);
		camera.setCountSold(20);
		
		// 정보은닉(데이터보호)
		camera.setPrice(-1);
		
		// countOfGoods 테스트
		Goods goods1 = new Goods();
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);
		
		camera.showInfo();
		
		camera.setPrice(500000);
		int discountPrice = camera.calcDiscountPrice(0.5);
		System.out.println(discountPrice);
		
		
	}

}
