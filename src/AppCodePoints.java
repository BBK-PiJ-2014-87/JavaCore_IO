import java.util.Arrays;


/**
 *  Application tests code points of characters.
 */
public class AppCodePoints {
	public static void main(String[] args) {
		testCodePoint(65);
		testCodePoint(10_000);
		testCodePoint(50_000);
		testCodePoint(165_536);
		
	}
	
	private static void testCodePoint(int codePoint){
		char[] charArray = Character.toChars(codePoint);
		System.out.println("char[]: " + Arrays.toString(charArray));
		String str = new String(charArray);
		System.out.println("String: " + str);
		System.out.println("String length: " + str.length());
		System.out.println("String.codePointCount: " + str.codePointCount(0, str.length()));
	}

}
