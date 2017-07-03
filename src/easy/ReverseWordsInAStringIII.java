package easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAStringIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// solution
	public String reverseWords(String s) {
		char[] charArray = s.toCharArray();
		List<Integer> spaceIndex = new ArrayList<Integer>();
		spaceIndex.add(-1);
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				spaceIndex.add(i);
			}
		}
		spaceIndex.add(charArray.length);

		int wordStart, wordEnd;
		char temp;
		for (int i = 0; i < spaceIndex.size() - 1; i++) {
			wordStart = spaceIndex.get(i) + 1;
			wordEnd = spaceIndex.get(i + 1) - 1;
			while (wordStart < wordEnd) {
				temp = charArray[wordStart];
				charArray[wordStart] = charArray[wordEnd];
				charArray[wordEnd] = temp;
				wordStart++;
				wordEnd--;
			}
		}
		return new String(charArray);
	}

	// other's solution
	public String reverseWords1(String s) {
		char[] ca = s.toCharArray();
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] != ' ') { // when i is a non-space
				int j = i;
				while (j + 1 < ca.length && ca[j + 1] != ' ') {
					j++;
				} // move j to the end of the word
				reverse(ca, i, j);
				i = j;
			}
		}
		return new String(ca);
	}

	private void reverse(char[] ca, int i, int j) {
		for (; i < j; i++, j--) {
			char tmp = ca[i];
			ca[i] = ca[j];
			ca[j] = tmp;
		}
	}

}
