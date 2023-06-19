
public class Main {
	
	public static void main(String[] args) {
		System.out.println(vratInteger(1));
		System.out.println(vratInt(1));
		System.out.println(vratDouble(1));
		System.out.println(vratDoub(1.56));
		System.out.println(vratLong(1));
		System.out.println(vratLongis((long) 5));
	}
	
	public static Integer vratInteger(int i) {
		return i + 1;
	}
	
	public static Double vratDouble(double i) {
		return i + 1;
	}
	
	public static Long vratLong(long i) {
		return i + 1;
	}
	
	public static int vratInt(Integer i) {
		return i + 1;
	}
	
	public static double vratDoub(Double i) {
		return i + 1;
	}
	
	public static long vratLongis(Long i) {
		return i + 1;
	}
	
}
