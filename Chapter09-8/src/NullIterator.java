import java.util.Iterator;
//���󿡼� ���� ������ �ݺ���. �ǳ� �� �̻� �ݺ��۾��� ó���� ��ü�� ���ٰ� ƨ��.
public class NullIterator implements Iterator {

	@Override
	public boolean hasNext() {
		//hasNext�� ȣ�� �� ������ false�� ����. ���� �߿�!!!
		return false;
	}

	@Override
	public Object next() {
		//next ȣ�� �� null�� ����
		return null;
	}
	
	public void remove() {
		//NullIterator���� remove �޼ҵ带 ���� �� ���� ����..
		throw new UnsupportedOperationException();
	}
}
