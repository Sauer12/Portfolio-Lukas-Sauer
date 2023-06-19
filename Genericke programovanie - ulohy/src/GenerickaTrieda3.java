
public class GenerickaTrieda3<T, A, B> {
	private T objekt1;
	private A objekt2;
	private B objekt3;
	
	public void pridajObjekty(T objekt1, A objekt2, B objekt3) {
		this.objekt1 = objekt1;
		this.objekt2 = objekt2;
		this.objekt3 = objekt3;
	}

	public T getObjekt1() {
		return objekt1;
	}

	public A getObjekt2() {
		return objekt2;
	}

	public B getObjekt3() {
		return objekt3;
	}
	
	
}
