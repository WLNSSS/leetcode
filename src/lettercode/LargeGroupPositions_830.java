package lettercode;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions_830 {
	public List<List<Integer>> largeGroupPositions(String s) {
		int prePoint = 0;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(i) != s.charAt(prePoint)) {
				if(i - prePoint >= 3) {
					List<Integer> tempResult = new ArrayList<Integer>();
					tempResult.add(prePoint);
					tempResult.add(i - 1);
					result.add(tempResult);
				}
				prePoint = i;
			}
		}
		if(s.length() >= 3 && s.charAt(s.length() - 1) == s.charAt(s.length() - 2)){
			if(s.length() - prePoint >= 3) {
				List<Integer> tempResult = new ArrayList<Integer>();
				tempResult.add(prePoint);
				tempResult.add(s.length() - 1);
				result.add(tempResult);
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		LargeGroupPositions_830 lgp = new LargeGroupPositions_830();
		lgp.largeGroupPositions("bababbabaa");
	}
}
