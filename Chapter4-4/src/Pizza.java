
public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies[] veggies;
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	public abstract void prepare();

	public void box() {
		System.out.println("���� ���ڿ� ���� �����ϱ�");
	}

	public void cut() {
		System.out.println("���� ����");
	}

	public void bake() {
		System.out.println("25�е��� 350������ ����");
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
		//�����̸���ºκ�
	}
}
