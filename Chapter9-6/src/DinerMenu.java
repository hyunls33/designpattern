import java.util.Iterator;

public class DinerMenu implements Menu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("ä�������ڿ� BLT", "��� ���� (�Ĺ���)������, ����, �丶�並 ���� �޴�", true, 2.99);
		addItem("BLT", "��� ���� ������, ����, �丶�並 ���� �޴�", false, 2.99);
		addItem("������ ����", "���� �����带 ����� ������ ����", false, 3.29);
		addItem("�ֵ���", "���ũ���Ʈ, ���� ���, ����, ġ� ��鿩�� �ֵ���", false, 3.05);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("�˼��մϴ�. �޴��� �� á���ϴ�. �� �̻� �߰��� �� �����ϴ�.");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	//getMenuItem�޼ҵ� ��ſ� Iterator�� �����ϴ� �޼ҵ� ����.
	//Ŭ���̾�Ʈ������ menuItem�� ��� �����Ǵ���, � ������ �����Ǿ��ִ��� �� �ʿ� ����.
	//�׳� �ݺ��ڸ� ����ؼ� �޴��� �ִ� �׸�鿡 �ϳ��� ������ �� ������ ��.
	public Iterator createIterator() {
		return new DinerIterator(menuItems);
		//�迭�� ��쿡�� ���� �ݺ��ڸ� �������־�� ��. �迭���� iterator�޼ҵ尡 ����, �迭 �ݺ��ڸ� ����� ��� ��ü�� ���� ����.
	}
}
