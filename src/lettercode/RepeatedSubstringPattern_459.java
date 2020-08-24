package lettercode;

public class RepeatedSubstringPattern_459 {
	public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		RepeatedSubstringPattern_459 r = new RepeatedSubstringPattern_459();
		r.repeatedSubstringPattern("abab");
	}

}
