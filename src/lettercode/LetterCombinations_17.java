package lettercode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations_17 {

	private static final String[] digitsRealation = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
	private List<String> finalResult = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
		dfs(digits,new ArrayList<String>());
		return finalResult;
    }
	
	public void dfs(String digits,List<String> result) {
		if(!digits.isEmpty()){
			char digit = digits.charAt(0);
			char[] drArr = digitsRealation[Integer.parseInt(digit + "") - 2].toCharArray();
			List<String> newResult = new ArrayList<String>();
			if(!result.isEmpty()) {
				for(String s : result) {
					for(char c : drArr) {
						newResult.add(s + c);
						dfs(digits.substring(1),newResult);
					}
				}
			}else {
				for(char c : drArr) {
					newResult.add(c + "");
					dfs(digits.substring(1),newResult);
				}
			}
		}else {
			finalResult = result;
		}		
	}
	
	public static void main(String[] args) {
		LetterCombinations_17 lc = new LetterCombinations_17();
		String digits = "23";
		List<String> result = lc.letterCombinations(digits);
		for(String s : result) {
			System.out.println(s);
		}

	}

}
