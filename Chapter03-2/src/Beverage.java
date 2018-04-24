
public abstract class Beverage {
	public enum Size {TALL, GRANDE, VENTI};//enum : �� Ÿ�� ������ ��� ������ ���� ���������ν� ������ �� ����
	Size size = Size.TALL;//Ŀ�� ������ ����
	String description = "���� ����";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return this.size;
	}
}