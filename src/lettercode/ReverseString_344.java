package lettercode;

public class ReverseString_344 {

	public void reverseString(char[] s) {
		int sLen = s.length;
		for(int i = 0,j = sLen - 1;i < sLen/2;i++,j--) {
			char tempS = s[i];
			s[i] = s[j];
			s[j] = tempS;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
