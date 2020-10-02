package lettercode;

public class NumJewelsInStones_771 {
	
	public int numJewelsInStones(String J, String S) {
		int result = 0;
		char[] jArr = J.toCharArray();
		char[] sArr = S.toCharArray();
		for(char s : sArr) 
			for(char j : jArr) 
				if(s == j) 
					result++;
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
