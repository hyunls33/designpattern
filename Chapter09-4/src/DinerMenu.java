import java.util.Iterator;

public class DinerMenu implements Menu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("채식주의자용 BLT", "통밀 위에 (식물성)베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99);
		addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99);
		addItem("오늘의 스프", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29);
		addItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("죄송합니다. 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}
	
	//getMenuItem메소드 대신에 Iterator를 리턴하는 메소드 생성.
	//클라이언트에서는 menuItem이 어떻게 관리되는지, 어떤 식으로 구현되어있는지 알 필요 없음.
	//그냥 반복자를 사용해서 메뉴에 있는 항목들에 하나씩 접근할 수 있으면 됨.
	public Iterator createIterator() {
		return new DinerIterator(menuItems);
		//배열의 경우에는 따로 반복자를 구현해주어야 함. 배열에는 iterator메소드가 없고, 배열 반복자를 만드는 방법 자체가 없기 때문.
	}
}
