import java.util.ArrayList;

public class Waitress {
	String name;
	
	public Waitress(String name) {
		this.name = name;
	}
	
	public void printMenu() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
		
		DinerMenu dinerMenu = new DinerMenu();
		MenuItem[] lunchItems = dinerMenu.getMenuItems();
		
		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = (MenuItem) breakfastItems.get(i);
			System.out.print(menuItem.getName()+" ");
			System.out.println(menuItem.getPrice()+" ");
			System.out.println(menuItem.getDescription());
		}
		
		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = (MenuItem) lunchItems[i];
			System.out.print(menuItem.getName()+" ");
			System.out.println(menuItem.getPrice()+" ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	public void printBreakfastMenu() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
		
		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = (MenuItem) breakfastItems.get(i);
			System.out.print(menuItem.getName()+" ");
			System.out.println(menuItem.getPrice()+" ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	public void printLunchMenu() {
		DinerMenu dinerMenu = new DinerMenu();
		MenuItem[] lunchItems = dinerMenu.getMenuItems();
		
		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = (MenuItem) lunchItems[i];
			System.out.print(menuItem.getName()+" ");
			System.out.println(menuItem.getPrice()+" ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	public void printVegetarianMenu() {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
		
		DinerMenu dinerMenu = new DinerMenu();
		MenuItem[] lunchItems = dinerMenu.getMenuItems();
		
		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = (MenuItem) breakfastItems.get(i);
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName()+" ");
				System.out.println(menuItem.getPrice()+" ");
				System.out.println(menuItem.getDescription());
			}
		}
		
		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = (MenuItem) lunchItems[i];
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName()+" ");
				System.out.println(menuItem.getPrice()+" ");
				System.out.println(menuItem.getDescription());
			}
		}
	}
	
	public boolean isItemVegetarian(String name) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
		
		DinerMenu dinerMenu = new DinerMenu();
		MenuItem[] lunchItems = dinerMenu.getMenuItems();
		
		for (int i = 0; i < breakfastItems.size(); i++) {
			MenuItem menuItem = (MenuItem) breakfastItems.get(i);
			if (menuItem.getName().equals(name) == true) {
				return true;
			}
		}
		
		for (int i = 0; i < lunchItems.length; i++) {
			MenuItem menuItem = (MenuItem) lunchItems[i];
			if (menuItem.getName().equals(name) == true) {
				return true;
			}
		}
		return false;
	}
}
