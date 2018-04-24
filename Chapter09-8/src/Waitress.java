import java.util.Iterator;

public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {//생성자에서 두 메뉴를 인자로 받아옴.
		this.allMenus = allMenus;
	}
	
	//전체 메뉴 출력 메소드
	public void printMenu() {
		allMenus.print();
	}
	
	public void printVegetarianMenu() {
		Iterator iterator = allMenus.createIterator();
		System.out.println("\n채식주의자 메뉴\n---");
		//복합 객체 내에 있는 모든 항목에 대해서 반복작업을 수행.
		while(iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			try {
				//각 원소의 isVegetarian메소드를 호출해서 true가 리턴되면 print메소드를 출력
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
					//print는 MenuItem객체에 대해서만 호출될 뿐, 복합 객체에 대해서는 호출되지 않음.
				}
			} catch (UnsupportedOperationException e) {}//예외를 잡긴 하지만 그냥 계속 반복하도록 설정.
		}
	}
}
