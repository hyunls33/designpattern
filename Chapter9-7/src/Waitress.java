
public class Waitress {
	MenuComponent allMenus;
	
	public Waitress(MenuComponent allMenus) {//생성자에서 두 메뉴를 인자로 받아옴.
		this.allMenus = allMenus;
	}
	
	//전체 메뉴 출력 메소드
	public void printMenu() {
		allMenus.print();
	}
}
