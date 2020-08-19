package lettercode;

public class CountSubstrings_647 {
	
	public int countSubstrings(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = s.length();
        for(int i = 0; i<n; i++) dp[i][i] = true;
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1]; 
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    result++;
                }
            }
        }
        return result;
        
    }

	public static void main(String[] args) {
		String s = "aaa";
		CountSubstrings_647 c = new CountSubstrings_647();
		System.out.println(c.countSubstrings(s));

	}

}
