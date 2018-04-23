import java.util.*;;

public class CompositeIterator implements Iterator {//java iterator �������̽� ����
	Stack stack = new Stack();
	
	//�ݺ��۾��� ó���� ��� �� �ֻ��� ���հ����� �ݺ��ڰ� ���޵�. �� �ݺ��ڴ� ���� �ڷᱸ���� �������.
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}
	
	public Object next() {
		//Ŭ���̾�Ʈ���� ���� ���Ҹ� ��û�ϸ� �켱 hasNext�� ȣ���ؼ� ���� ���Ұ� �����ִ��� Ȯ��.
		if (hasNext()) {
			//���� ���Ұ� ������ ���ÿ��� ���� �ݺ��ڸ� ���� �� �� ���� ���� ����. 
			Iterator iterator = (Iterator) stack.peek();
			MenuComponent component = (MenuComponent) iterator.next();
			if (component instanceof Menu) {
				//�� ���Ұ� �޴��� �ݺ��۾��� �� �ٸ� ���հ�ü�� �߰��� ���̹Ƿ� ���ÿ� ���� �j��. ���Ұ� �޴��� �ƴϵ� ������� ��ü�� ����.
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}
	
	public boolean hasNext() {
		//���� ���Ұ� �ִ��� Ȯ���� ���� ������ ���캸�� ��. ������ ��������� ���� ���Ұ� ���ٴ� ��.
		if (stack.empty()) {
			return false;
		} else {
			//������ ������� ������ ���� �� ������ �ݺ��ڸ� ������ ���� ���Ұ� �ִ��� �˾ƺ�.
			Iterator iterator = (Iterator) stack.peek();
			//���� ���Ұ� ������ ���� �� ���� �ִ� ��ü�� ���� ���� ��������� hasNext�� ȣ��.
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
