package easy;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString(""));
		StringBuilder sb = new StringBuilder("hello");
		System.out.println(sb.reverse());
	}

	public static String reverseString(String s) {
		if (s == null)
			return null;
		char[] charArray = s.toCharArray();// if s is null, this method will
											// throw null pointer exception
		char temp;
		// this can also use while loop
		for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
			temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
		}
		return new String(charArray);

	}

}
