//Beverage��ü�� �� �ڸ��� �� �� �־�� �ϹǷ�... Beverage Ŭ���� Ȯ��
public abstract class CondimentDecorator extends Beverage {
	public Beverage beverage;
	
	public abstract String getDescription();//��� ÷���� ���ڷ����Ϳ��� getDescription�޼ҵ带 ���� ������ ��ȹ
	
	public Size getSize() {
		return beverage.getSize();
	}
}
