import java.util.*;;

public class CompositeIterator implements Iterator {//java iterator 인터페이스 구현
	Stack stack = new Stack();
	
	//반복작업을 처리할 대상 중 최상위 복합객테의 반복자가 전달됨. 그 반복자는 스택 자료구조에 집어넣음.
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}
	
	public Object next() {
		//클라이언트에서 다음 원소를 요청하면 우선 hasNext를 호출해서 다음 원소가 남아있는지 확인.
		if (hasNext()) {
			//다음 원소가 있으면 스택에서 현재 반복자를 꺼낸 후 그 다음 원소 구함. 
			Iterator iterator = (Iterator) stack.peek();
			MenuComponent component = (MenuComponent) iterator.next();
			if (component instanceof Menu) {
				//그 원소가 메뉴면 반복작업에 또 다른 복합개체가 추가된 것이므로 스택에 집어 엏음. 원소가 메뉴든 아니든 구성요소 자체는 리턴.
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}
	
	public boolean hasNext() {
		//다음 원소가 있는지 확인할 때는 스택을 살펴보면 됨. 스택이 비어있으면 다음 원소가 없다는 것.
		if (stack.empty()) {
			return false;
		} else {
			//스택이 비어있지 않으면 스택 맨 위에서 반복자를 꺼내서 다음 원소가 있는지 알아봄.
			Iterator iterator = (Iterator) stack.peek();
			//다음 원소가 없으면 스택 맨 위에 있는 객체를 꺼낸 다음 재귀적으로 hasNext를 호출.
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
