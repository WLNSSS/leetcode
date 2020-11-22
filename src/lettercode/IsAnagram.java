package lettercode;

import java.util.ArrayList;
import java.util.Arrays;

public class IsAnagram {
	
	public boolean isAnagram(String s, String t) {
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
	
	public static void main(String[] args) {
		IsAnagram ia = new IsAnagram();
		ia.isAnagram("anagram", "nagaram");
	}
}
