
public class GenerickaTrieda2<T,P> {
	
	private T objekt1;
	private P objekt2;
	
	public void pridajObjekty(T objekt1, P objekt2) {
		this.objekt1 = objekt1;
		this.objekt2 = objekt2;
	}
	
	public T vratObjekt1() {
		return objekt1;
	}
	
	public P vratObjetk2() {
		return objekt2;
	}
	
}
