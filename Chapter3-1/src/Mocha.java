//CondimentDecorator���� Beverage�� Ȯ����
public class Mocha extends CondimentDecorator {//Mocha�� ���ڷ����ʹϱ� CondimentDecorator�� ���
	Beverage beverage;//���ΰ��� �ϴ� ���Ḧ �����ϱ� ���� �ν��Ͻ� ����
	
	public Mocha(Beverage beverage) {
		//�ν��Ͻ� ������ ���ΰ��� �ϴ� ��ü�� �����ϱ� ���� ������. ���ڷ������� �����ڿ� ���ΰ����ϴ� ���� ��ü�� �����ϴ� ���
		this.beverage = beverage;
	}
	
	public String getDescription() {
		//����ϰ� �ִ� ��ü�� �۾��� ������ ����. �� ����� ", ��ī"�� ���� ����� ������.
		return beverage.getDescription() + ", ��ī";
	}
	
	public double cost() {
		//���� ���ݿ� ��ī�� �߰��� ������ ���.
		//����ϰ� �ִ� ��ü�� ������ ���ϴ� �۾��� �����ؼ� ���� ��ü�� ���� ���� ����. �ű⿡ ��ī ������ ���� ������ ������.
		return .20 + beverage.cost();
	}
}
