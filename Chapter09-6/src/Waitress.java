import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
	ArrayList<Menu> menus;
	
	public Waitress(ArrayList<Menu> menus) {//�����ڿ��� �� �޴��� ���ڷ� �޾ƿ�.
		this.menus = menus;
	}
	
	//��ü �޴� ��� �޼ҵ�
	public void printMenu() {
		//�޴����� �ݺ��� �ʿ� ����.
		Iterator menuIterator = menus.iterator();
		
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printMenu(menu.createIterator());
		}
	}
	
	//�ݺ��Ǵ� �ڵ�� �����ε�(�ݺ��ڸ� ����Ͽ� ��� �޴��� ���)
	public void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {//�׸��� �� �ִ��� Ȯ��. ������ �ݺ�.
			MenuItem menuItem = (MenuItem) iterator.next();//���� �׸� ������.
			System.out.print(menuItem.getName()+", ");
			System.out.print(menuItem.getPrice()+" -- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	//ä�������� �޴� ��� �޼ҵ�
	public void printVegetarianMenu() {
		Iterator menuIterator = menus.iterator();
		
		while (menuIterator.hasNext()) {
			Menu menu = (Menu) menuIterator.next();
			printVegetarianMenu(menu.createIterator());
		}
	}
	
	//�ݺ��Ǵ� �ڵ�� �����ε�
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
	
	//ä�������� �޴����� Ȯ���ϴ� �޼ҵ�
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
	
	//�ݺ��Ǵ� �ڵ�� �����ε�
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
