
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public void fill() {
		//���Ϸ��� ����� ���� ��Ḧ ä������.
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}
	
	public void drain() {
		//���Ϸ��� ������� �ʰ�, �� ������ ���¿����� ���Ϸ��� ����ִ� ��Ḧ �����ܰ�� �ѱ�.
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}
	
	public void boil() {
		//���Ϸ��� ���� �� �ְ�, ���� ���� ���� ���¿����� ���ݸ��� ������ ȥ�յ� ��Ḧ ����.
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}
