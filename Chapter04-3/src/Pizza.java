import java.util.ArrayList;

public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<String>();
	
	public void prepare() {
		System.out.println("Preparing "+name);
		System.out.println("Tossing dough... ");
		System.out.println("Adding sauce... ");
		System.out.print("Adding toppings : ");
		for (int i = 0; i < toppings.size(); i++) {
			System.out.println("   "+toppings.get(i));
		}
	}

	public void box() {
		System.out.println("피자 상자에 피자 포장하기");
	}

	public void cut() {
		System.out.println("피자 컷팅");
	}

	public void bake() {
		System.out.println("25분동안 350도에서 굽기");
	}

	public String getName() {
		return name;
	}
}
