
public class GumballMachine {
	//4���� ���� ����
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	//���� ���¸� �����ϱ� ���� ����
	int state = SOLD_OUT;
	int count = 0;
	
	public GumballMachine(int count) {
		this.count = count;//�ʱ� �˸��� ������ ���ڷ� �ޱ�.
		//�˸��� ������ 0�� �ƴϸ� ������ �ֱ⸦ ��ٸ��� �ִ� NO_QUARTER���·� ��ȯ. 0�̸� SOLD_OUT����.
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	
	//������ ���ԉ��� ���� �޼ҵ�
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			//������ �̹� ���ԵǾ� �ִ� ��쿡�� ������ �̹� �� �ִٰ� �˸�.
			System.out.println("������ �� ���� �־��ּ���.");
		} else if (state == NO_QUARTER) {
			//������ ���µ� ���� ��쿡�� ������ ���� ���� ���� ���·� ��ȯ.
			state = HAS_QUARTER;
			System.out.println("������ �����̽��ϴ�.");
		} else if (state == SOLD_OUT) {
			//���� ���¿����� ������ ��ȯ.
			System.out.println("�����Ǿ����ϴ�. ���� ��ȸ�� �̿����ּ���.");
		} else if (state == SOLD) {
			//��� �����̸� ������ ���� �˸��� �ǸŻ��¿� �ִٸ� ���� �� ��ٷ� �޶�� �޼��� ���.
			System.out.println("��� ��ٷ� �ּ���. �˸��̰� ������ �ֽ��ϴ�.");
		}
	}
	
	//����ڰ� ������ ��ȯ �������� �ϴ� ����� �޼ҵ�
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			//������ ������ ��ȯ�ϰ� NO_QUARTER���·� ��ȯ
			System.out.println("������ ��ȯ�˴ϴ�.");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			//������ ���µ� ������ �� ����
			System.out.println("������ �־��ּ���.");
		} else if (state == SOLD_OUT) {
			//�����̸� �̹� �������� ������ ������ �� ����. �̹� �̱⸦ �����ϱ�.
			System.out.println("�̹� �˸��̸� �����̽��ϴ�.");
		} else if (state == SOLD) {
			//���� ���¿����� ������ ������ �� ���� ������ ������ �ϵ� ����
			System.out.println("������ ���� �����̽��ϴ�. ������ ��ȯ���� �ʽ��ϴ�.");
		}
	}
	
	//�����̸� ������ ����� �޼ҵ�
	public void turnCrank() {
		if (state == SOLD) {
			//�̹� �ȷȴµ� �����̸� �� ������ ���
			System.out.println("�����̴� �� ���� �����ּ���.");
		} else if (state == NO_QUARTER) {
			//������ ���� �־�� ��.
			System.out.println("������ �־��ּ���.");
		} else if (state == SOLD_OUT) {
			//�˸��̰� ���� ������ �ƹ��͵� �� �� ����
			System.out.println("�����Ǿ����ϴ�.");
		} else if (state == HAS_QUARTER) {
			//����! ����ڰ� �˸��̸� ���� �� ����.
			System.out.println("�����̸� �����̽��ϴ�.");
			state = SOLD;//���¸� SOLD�� ��ȯ.
			dispense();//�˸��� ������ �޼ҵ� ȣ��
		}
	}
	
	//�˸��� ������ �޼ҵ�
	public void dispense() {
		if (state == SOLD) {
			//�ȷ����Ƿ� �˸��� ��������
			System.out.println("�˸��̰� ������ �ֽ��ϴ�.");
			count = count - 1;
			//�����Ǿ����� Ȯ��
			if (count == 0) {
				//��� ���� �˸��̰� ������ �˸��̸� ��踦 SOLD_OUT���� ����
				System.out.println("�� �̻� �˸��̰� �����ϴ�.");
				state = SOLD_OUT;
			} else {
				//�ƴϸ� NO_QUARTER�� ����
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("������ �־��ּ���.");
		} else if (state == SOLD_OUT) {
			System.out.println("�����Դϴ�.");
		} else if (state == HAS_QUARTER) {
			System.out.println("�˸��̰� ���� �� �����ϴ�.");
		}
	}
	
	//�˸��� ä��� �޼ҵ�
	public void refill(int count) {
		this.count = this.count + count;
		state = NO_QUARTER;
	}

	//���� �޼ҵ�
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n�̱� ���\n");
		result.append("���� �� : " + count + " ��");
		result.append("\n��� ���´� ");
		if (state == SOLD_OUT) {
			result.append("����");
		} else if (state == NO_QUARTER) {
			result.append("���� ����. ���� ���� ��ٸ��� ��");
		} else if (state == HAS_QUARTER) {
			result.append("���� ����. ������ ������ ��ٸ��� ��");
		} else if (state == SOLD) {
			result.append("�˸��� �ȸ�. �˸��� �������� ��");
		}
		result.append("\n");
		return result.toString();
	}
}
