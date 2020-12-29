package lettercode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinPatches {
	boolean[] numsState;
	int[] newNums;
	public int minPatches(int[] nums, int n) {
		numsState = new boolean[nums.length];
		newNums = nums;
		int result = 0;
		for(int i = 1;i <= n;i++) {
			if(!recur(newNums,numsState,new ArrayList<Integer>(),i)) {
				addNumber(i);
				result++;
			}
			numsState = new boolean[newNums.length];
		}
		return result;
    }
	
	public boolean recur(int[] nums,boolean[] numsState,List<Integer> memorey,int n) {
		if(n == 0 || memorey.contains(n)) {
			return true;
		}
		for(int i = 0;i <nums.length && nums[i] <= n;i++) {
			if(numsState[i] != true) {
				numsState[i] = true;
				boolean result = recur(nums,numsState,memorey,n - nums[i]);
				if(result == false) {
					numsState[i] = false;
				}else {
					memorey.add(n);
					return true;
				}
			}
		}
		return false;
	}
	
	public void addNumber(int n) {
		int[] tempNums = new int[newNums.length + 1];
		for(int i = 0;i < newNums.length;i++) {
			tempNums[i] = newNums[i];
		}
		tempNums[newNums.length] = n;
		Arrays.sort(tempNums);
		newNums = tempNums;
	}
	
	public static void main(String[] args) {
		MinPatches mp = new MinPatches();
		int[] nums = {1,3};
		System.out.println(mp.minPatches(nums, 6));;
	}
}
