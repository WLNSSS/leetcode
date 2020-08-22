package lettercode;

public class RepeatedSubstringPattern_459 {
	public boolean repeatedSubstringPattern(String s) {
		boolean flag = false;
		int rangeLen = s.length() / 2 + 1;
		for(int i = 0;i < rangeLen;i++) {
			String[] tempStr = s.split(s.substring(0,i));
			if(tempStr.length == 0) {
				flag = true;
				break;
			}
		}
		return flag;
    }
	
	public static void main(String[] args) {
		RepeatedSubstringPattern_459 r = new RepeatedSubstringPattern_459();
		r.repeatedSubstringPattern("abab");
	}

}
