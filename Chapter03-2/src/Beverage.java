
public abstract class Beverage {
	public enum Size {TALL, GRANDE, VENTI};//enum : 그 타입 변수의 모든 가능한 값을 열거함으로써 지정할 수 있음
	Size size = Size.TALL;//커피 사이즈 지정
	String description = "제목 없음";
	
	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return this.size;
	}
}
