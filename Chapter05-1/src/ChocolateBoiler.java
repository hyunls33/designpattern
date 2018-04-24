
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	public ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public void fill() {
		//보일러가 비었을 때만 재료를 채워넣음.
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}
	
	public void drain() {
		//보일러가 비어있지 않고, 다 끓여진 상태에서만 보일러에 들어있는 재료를 다음단계로 넘김.
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}
	
	public void boil() {
		//보일러가 가득 차 있고, 아직 끓지 않은 상태에서만 초콜릿과 우유가 혼합된 재료를 끓임.
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
}
