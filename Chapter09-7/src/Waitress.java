
public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {//�����ڿ��� �� �޴��� ���ڷ� �޾ƿ�.
		this.allMenus = allMenus;
	}
	
	//��ü �޴� ��� �޼ҵ�
	public void printMenu() {
		allMenus.print();
	}
}
