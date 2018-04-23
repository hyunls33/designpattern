import java.util.Enumeration;
import java.util.Iterator;

//Enumeration¿ë Iterator¾î´ðÅÍ
public class EnumerationIterator implements Iterator {
	Enumeration enume;
	
	public EnumerationIterator(Enumeration enume) {
		this.enume = enume;
	}
	
	@Override
	public boolean hasNext() {
		return enume.hasMoreElements();
	}

	@Override
	public Object next() {
		return enume.nextElement();
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
