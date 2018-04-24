import java.util.Iterator;

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
	
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {//�����ڿ��� �� �޴��� ���ڷ� �޾ƿ�.
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	//��ü �޴� ��� �޼ҵ�
	public void printMenu() {
		//�޴����� �ݺ������ �ϹǷ� ���� �ݺ��� ����.
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		
		//�� �ݺ��ڷ� �����ε��� prinMenu�� ȣ��
		System.out.println("�޴�\n----\n��ħ �޴�");
		printMenu(pancakeIterator);
		System.out.println("\n���� �޴�");
		printMenu(dinerIterator);
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
	
	//��ħ �޴� ��� �޼ҵ�
	public void printBreakfastMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();

		System.out.println("�޴�\n----\n��ħ �޴�");
		printMenu(pancakeIterator);
	}
	
	//���� �޴� ��� �޼ҵ�
	public void printLunchMenu() {
		Iterator dinerIterator = dinerMenu.createIterator();
		
		System.out.println("�޴�\n----\n���� �޴�");
		printMenu(dinerIterator);
	}
	
	//ä�������� �޴� ��� �޼ҵ�
	public void printVegetarianMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("ä�������� �޴�\n----\n��ħ �޴�");
		printVegetarianMenu(pancakeIterator);
		System.out.println("\n���� �޴�");
		printVegetarianMenu(dinerIterator);
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
