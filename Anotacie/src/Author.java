
public @interface Author {
	String name();
	String date();
	String company() default "Telekom";
}
