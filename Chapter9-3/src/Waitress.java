import java.util.Iterator;

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
	
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {//생성자에서 두 메뉴를 인자로 받아옴.
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	//전체 메뉴 출력 메소드
	public void printMenu() {
		//메뉴마다 반복해줘야 하므로 각각 반복자 생성.
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		
		//각 반복자로 오버로드한 prinMenu를 호출
		System.out.println("메뉴\n----\n아침 메뉴");
		printMenu(pancakeIterator);
		System.out.println("\n점심 메뉴");
		printMenu(dinerIterator);
	}
	
	//반복되는 코드는 오버로드(반복자를 사용하여 모든 메뉴를 출력)
	public void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {//항목이 더 있는지 확인. 있으면 반복.
			MenuItem menuItem = (MenuItem) iterator.next();//다음 항목 가져옴.
			System.out.print(menuItem.getName()+", ");
			System.out.print(menuItem.getPrice()+" -- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	//아침 메뉴 출력 메소드
	public void printBreakfastMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();

		System.out.println("메뉴\n----\n아침 메뉴");
		printMenu(pancakeIterator);
	}
	
	//점심 메뉴 출력 메소드
	public void printLunchMenu() {
		Iterator dinerIterator = dinerMenu.createIterator();
		
		System.out.println("메뉴\n----\n점심 메뉴");
		printMenu(dinerIterator);
	}
	
	//채식주의자 메뉴 출력 메소드
	public void printVegetarianMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("채식주의자 메뉴\n----\n아침 메뉴");
		printVegetarianMenu(pancakeIterator);
		System.out.println("\n점심 메뉴");
		printVegetarianMenu(dinerIterator);
	}
	
	//반복되는 코드는 오버로드
	public void printVegetarianMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			if (menuItem.isVegetarian()) {
				System.out.print(menuItem.getName()+", ");
				System.out.print(menuItem.getPrice()+" -- ");
				System.out.println(menuItem.getDescription());
			}
		}
	}
	
	//채식주의자 메뉴인지 확인하는 메소드
	public boolean isItemVegetarian(String name) {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		
		if (isItemVegetarian(name, pancakeIterator)) {
			return true;
		}
		
		if (isItemVegetarian(name, dinerIterator)) {
			return true;
		}
		
		return false;
	}
	
	//반복되는 코드는 오버로드
	public boolean isItemVegetarian(String name, Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem menuItem = (MenuItem) iterator.next();
			if (menuItem.getName().equals(name) == true) {
				return true;
			}
		}
		
		return false;
	}
}
