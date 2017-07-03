package microSoftOA;

public class GenerateLowestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String GenerateLowestNumber(String number, int n) {
		// convert parameter number to StringBuffer, so we can use methods
		// like delete() to delete a char at specified index
		StringBuffer sb = new StringBuffer(number);
		int i; // keep track of how many digits has been removed

		int j;

		for (i = 0; i < n; i++) {
			// go through each digit in number, if current digit is
			// smaller than next digit, do nothing
			for (j = 0; j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1); j++) {
			}
			// if current digit is greater than next digit, delete
			// current digit
			sb.delete(j, j + 1);
		}
		// remove leading zeros
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.delete(0, 1);
		}
		// return empty string if all digits are removed
		return sb.toString();

	}
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0;i<k;i++){
            int j = 0;
            while(j<sb.length()&&sb.char(j)<sb.charAt(j+1)){
                j++;
            }
            sb.delete(j,j+1);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.delete(0, 1);
		}
        return sb.length()==0?"0":sb.toString();
    }
}
