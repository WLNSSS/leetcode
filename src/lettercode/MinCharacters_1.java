package lettercode;

import java.util.HashSet;
import java.util.Set;

public class MinCharacters_1 {
	public int minCharacters(String a, String b) {
		int result = Integer.MAX_VALUE;
		Set<Character> aSet = new HashSet<Character>();
		Set<Character> bSet = new HashSet<Character>();
		char[] aArr = a.toCharArray();
		char aMax = 'A',aMin = '{',bMax = 'A',bMin = '}';
		char[] bArr = b.toCharArray();
		for(char aChar : aArr) {
			aSet.add(aChar);
			if(aChar > aMax) 
				aMax = aChar;
			if(aChar < aMin)
				aMin = aChar;
		}
		for(char bChar : bArr) {
			bSet.add(bChar);
			if(bChar > bMax) 
				bMax = bChar;
			if(bChar < bMin)
				bMin = bChar;
		}
		Character[] aSetArr = aSet.toArray(new Character[aSet.size()]);
		Character[] bSetArr = bSet.toArray(new Character[bSet.size()]);
		//case1
		int tempResult = Integer.MAX_VALUE;
		for(int i = 0;i < aSetArr.length;i++) {
			tempResult = 0;
			if(aSetArr[i] < bMin) {
				for(int j = 0;j < aArr.length;j++) {
					if(aArr[j] != aSetArr[i]) {
						tempResult++;
					}
				}
			}
			if(result > tempResult && tempResult != 0) {
				result = tempResult;
			}
		}
		//
		for(int i = 0;i < bSetArr.length;i++) {
			tempResult = 0;
			if(bSetArr[i] > aMax) {
				for(int j = 0;j < bArr.length;j++) {
					if(bArr[j] != bSetArr[i]) {
						tempResult++;
					}
				}
			}
			if(result > tempResult && tempResult != 0) {
				result = tempResult;
			}
		}
		//case2
		tempResult = 0;
		for(int i = 0;i < bSetArr.length;i++) {
			tempResult = 0;
			if(bSetArr[i] < aMin) {
				for(int j = 0;j < bArr.length;j++) {
					if(bArr[j] != bSetArr[i]) {
						tempResult++;
					}
				}
			}
			if(result > tempResult && tempResult != 0) {
				result = tempResult;
			}
		}
		//
		for(int i = 0;i < aSetArr.length;i++) {
			tempResult = 0;
			if(aSetArr[i] > bMax) {
				for(int j = 0;j < aArr.length;j++) {
					if(aArr[j] != aSetArr[i]) {
						tempResult++;
					}
				}
			}
			if(result > tempResult && tempResult != 0) {
				result = tempResult;
			}
		}
		//case3
		return result;
    }
	public static void main(String[] args) {
		MinCharacters_1 mc = new MinCharacters_1();
		mc.minCharacters("aba", "caa");
	}
}
