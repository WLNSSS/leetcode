package lettercode;

import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    
	private List<List<Integer>> results = new ArrayList<List<Integer>>();
	public List<List<Integer>> permute(int[] nums) {
		boolean[] numsFlag = new boolean[nums.length];
		dfs(nums,numsFlag,new ArrayList<Integer>());
		return results;
    }
	
	private void dfs(int[] nums,boolean[] numsFlag,List<Integer> result) {
		int numsLen = nums.length;
		if(result.size() == numsLen) {
			results.add(result);
			return;
		}
		for(int i = 0;i < numsLen;i++) {
			if(numsFlag[i])
				continue;
			boolean[] newNumsFlag = numsFlag.clone();
			List<Integer> newResult = new ArrayList<Integer>(result);
			newResult.add(nums[i]);
			newNumsFlag[i] = true;
			dfs(nums,newNumsFlag,newResult);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Permute_46 p = new Permute_46();
		p.permute(nums);

	}

}
