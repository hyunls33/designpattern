import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu {
	Hashtable menuItems = new Hashtable();//hashtable�� �پ��� ���� �����ϱ� ���� �뵵�� ���� ���̴� �ڷᱸ��. hashmap���� �ص� ��.
	
	public CafeMenu() {
		addItem("���� ���ſ� ���� ������", "��л�, ����, �丶��, ����Ƣ���� ÷���� ��������", true, 3.99);
		addItem("������ ����", "�����尡 ��鿩�� ������ ����", false, 3.69);
		addItem("������", "�� ������� ���, ����ī���� ��鿩�� Ǫ���� ������", true, 4.29);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}
	
	/*//iterator�� ����ϸ� �ʿ� ����.
	public Hashtable getItems() {
		return menuItems;
	}*/
	
	public Iterator createIterator() {
		//values() : �ؽ����̺� ����ִ� ��� ��ü���� �÷����� ������
		//iterator() : iterator������ ��ü�� �����ϴ� �޼ҵ�
		return menuItems.values().iterator();
	}
}
