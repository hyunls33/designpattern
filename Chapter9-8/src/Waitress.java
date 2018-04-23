import java.util.Iterator;

public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {//�����ڿ��� �� �޴��� ���ڷ� �޾ƿ�.
		this.allMenus = allMenus;
	}
	
	//��ü �޴� ��� �޼ҵ�
	public void printMenu() {
		allMenus.print();
	}
	
	public void printVegetarianMenu() {
		Iterator iterator = allMenus.createIterator();
		System.out.println("\nä�������� �޴�\n---");
		//���� ��ü ���� �ִ� ��� �׸� ���ؼ� �ݺ��۾��� ����.
		while(iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			try {
				//�� ������ isVegetarian�޼ҵ带 ȣ���ؼ� true�� ���ϵǸ� print�޼ҵ带 ���
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
					//print�� MenuItem��ü�� ���ؼ��� ȣ��� ��, ���� ��ü�� ���ؼ��� ȣ����� ����.
				}
			} catch (UnsupportedOperationException e) {}//���ܸ� ��� ������ �׳� ��� �ݺ��ϵ��� ����.
		}
	}
}
