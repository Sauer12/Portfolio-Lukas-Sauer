package web;

public interface WebInterface<T extends Element> {
	
	public void vlozElement(T element);
	public T vratElement();
	public void odoberElement(T element);
}
