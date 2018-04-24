import java.util.ArrayList;

public class MenuTestDriver {
	public static void main(String[] args) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		CafeMenu cafeMenu = new CafeMenu();
		
		ArrayList<Menu> menu = new ArrayList<Menu>();
		menu.add(pancakeHouseMenu);
		menu.add(dinerMenu);
		menu.add(cafeMenu);
		
		Waitress waitress = new Waitress(menu);
		
		waitress.printVegetarianMenu();
	}
}
