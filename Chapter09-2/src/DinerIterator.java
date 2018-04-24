
public class DinerIterator implements Iterator {//iterator 인터페이스 구현
	MenuItem[] items;
	int position = 0;//배열에 대한 반복작업이 있기 때문에 현재 위치 저장
	
	public DinerIterator(MenuItem[] items) {//반복 작업을 수행할 메뉴 항목 배열을 인자로 받음
		this.items = items;
	}
	
	public Object next() {//배열의 다음 원소를 리턴하고 position값 1증가시킴
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}
	
	public boolean hasNext() {//배열에 있는 모든 원소를 돌았는지 확인함. 더 돌아야 하면 true를 리턴.
		//최대 개수가 정해진 배열을 만들었기 때문에, 배열 끝에 있는지를 확인하는 것 외에도 다음 항목이 null인지도 확인해야 함.
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}
}
