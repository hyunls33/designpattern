
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
}
