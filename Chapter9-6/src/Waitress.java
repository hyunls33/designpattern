import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
	ArrayList<Menu> menus;
	
	public Waitress(ArrayList<Menu> menus) {//생성자에서 두 메뉴를 인자로 받아옴.
		this.menus = menus;
	}
	
	//전체 메뉴 출력 메소드
	public void printMenu() {
		//메뉴마다 반복할 필요 없음.
		Iterator menuIterator = menus.iterator();
		
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printMenu(menu.createIterator());
		}
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
	
	//채식주의자 메뉴 출력 메소드
	public void printVegetarianMenu() {
		Iterator menuIterator = menus.iterator();
		
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printVegetarianMenu(menu.createIterator());
		}
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
		Iterator menuIterator = menus.iterator();
		
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			if (isItemVegetarian(name, menuIterator)) {
				return true;
			}
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
