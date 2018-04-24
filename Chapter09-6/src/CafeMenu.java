import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu {
	Hashtable menuItems = new Hashtable();//hashtable은 다양한 값을 저장하기 위한 용도로 많이 쓰이는 자료구조. hashmap으로 해도 됨.
	
	public CafeMenu() {
		addItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지버거", true, 3.99);
		addItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", false, 3.69);
		addItem("베리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또", true, 4.29);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(menuItem.getName(), menuItem);
	}
	
	/*//iterator를 사용하면 필요 없음.
	public Hashtable getItems() {
		return menuItems;
	}*/
	
	public Iterator createIterator() {
		//values() : 해시테이블에 들어있는 모든 객체들의 컬렉션을 리턴함
		//iterator() : iterator형식의 객체를 리턴하는 메소드
		return menuItems.values().iterator();
	}
}
