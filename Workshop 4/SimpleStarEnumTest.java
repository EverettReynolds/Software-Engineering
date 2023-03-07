
public class SimpleStarEnumTest {

	public static void main(String[] args) {
		for (SimpleStarEnum sse : SimpleStarEnum.values()) {
			System.out.println(sse + "=" + sse.name() + "@" + sse.ordinal());
			System.out.println("\t" + sse.toString() + "=" + SimpleStarEnum.Earth
					 + ":" + sse.equals(SimpleStarEnum.Earth));
		}
	}

}
