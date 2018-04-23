import java.util.Iterator;
//세상에서 제일 게으른 반복자. 맨날 더 이상 반복작업을 처리할 객체가 없다고 튕김.
public class NullIterator implements Iterator {

	@Override
	public boolean hasNext() {
		//hasNext가 호출 시 무조건 false를 리턴. 가장 중요!!!
		return false;
	}

	@Override
	public Object next() {
		//next 호출 시 null을 리턴
		return null;
	}
	
	public void remove() {
		//NullIterator에서 remove 메소드를 지원 할 리가 없음..
		throw new UnsupportedOperationException();
	}
}
