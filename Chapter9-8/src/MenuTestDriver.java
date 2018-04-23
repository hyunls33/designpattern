
public class MenuTestDriver {
	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("������ũ �Ͽ콺 �޴�", "��ħ �޴�");
		MenuComponent dinerMenu = new Menu("��ü���� �Ĵ� �޴�", "���� �޴�");
		MenuComponent cafeMenu = new Menu("ī�� �޴�", "���� �޴�");
		MenuComponent dessertMenu = new Menu("����Ʈ �޴�", "����Ʈ�� ��� ������!");
		
		MenuComponent allMenus = new Menu("��ü �޴�", "��ü �޴�");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		//�޴� �׸��� �߰��ϴ� �κ�
		pancakeHouseMenu.add(new MenuItem("K&B ������ũ ��Ʈ", "��ũ���� ���׿� �佺Ʈ�� ��鿩�� ������ũ", true, 2.99));
		dinerMenu.add(new MenuItem("�Ľ�Ÿ", "�������� �ҽ� ���İ�Ƽ. ȿ�𻧵� �帳�ϴ�.", true, 3.89));
		dinerMenu.add(dessertMenu);
		dessertMenu.add(new MenuItem("���� ����", "�ٻ�ٻ��� ũ����Ʈ�� �ٴҶ� ���̽�ũ���� ���� �ִ� ���� ����", true, 1.59));
		cafeMenu.add(new MenuItem("������", "�� ������� ���, ����ī���� ��鿩�� Ǫ���� ������", true, 4.29));
		
		//�޴� �׸��� �߰�
		Waitress waitress = new Waitress(allMenus);
		waitress.printVegetarianMenu();
	}
}
