import java.util.Iterator;

public class DinerIterator implements Iterator {//iterator �������̽� ����
	MenuItem[] items;
	int position = 0;//�迭�� ���� �ݺ��۾��� �ֱ� ������ ���� ��ġ ����
	
	public DinerIterator(MenuItem[] items) {//�ݺ� �۾��� ������ �޴� �׸� �迭�� ���ڷ� ����
		this.items = items;
	}
	
	public Object next() {//�迭�� ���� ���Ҹ� �����ϰ� position�� 1������Ŵ
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}
	
	public boolean hasNext() {//�迭�� �ִ� ��� ���Ҹ� ���Ҵ��� Ȯ����. �� ���ƾ� �ϸ� true�� ����.
		//�ִ� ������ ������ �迭�� ������� ������, �迭 ���� �ִ����� Ȯ���ϴ� �� �ܿ��� ���� �׸��� null������ Ȯ���ؾ� ��.
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void remove() {
		//ũ�Ⱑ ������ �迭�� ����߱� ������ remove�� ȣ��Ǹ� ��� �׸��� �� ĭ�� �о���� ��.
		if (position <= 0) {
			throw new IllegalStateException("next()�� �� ���� ȣ������ ���� ���¿����� ������ �� �����ϴ�.");
		}
		
		if (items[position-1] != null) {
			for (int i = position-1; i < (items.length-1); i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}
}
