
public class GenerickaTrieda<P> {
	private P objekt;
	
	public void pridajObjekt(P objekt) {
		this.objekt = objekt;
	}
	
	public P vratObjekt() {
		return objekt;
	}
	
}
