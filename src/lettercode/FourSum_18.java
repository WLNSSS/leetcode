package lettercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FourSum_18 {

	List<List<Integer>> results = new ArrayList<List<Integer>>();
	HashSet<List<Integer>> resultsHashSet = new HashSet<List<Integer>>();
	public List<List<Integer>> fourSum(int[] nums, int target) {
		boolean[] numsUsed = new boolean[nums.length];
		List<Integer> result = new ArrayList<Integer>();
		dfs(nums,numsUsed,target,result,0);
		return results;
    }
	
	public void dfs(int[] nums,boolean[] numsUsed, int target,List<Integer> result,int cur) {
		if(result.size() == 4) {
			if(target == 0 && !resultsContain(result)) {
				results.add(new ArrayList<Integer>(result));
				
			}
			return;
		}
		int numsLen = nums.length;
		for(int i =0;i < numsLen;i++) {
			if(numsUsed[i] == true)
				continue;
			result.add(nums[i]);
			numsUsed[i] = true;
			dfs(nums,numsUsed,target - nums[i],result,i + 1);
			result.remove(result.size() - 1);
			numsUsed[i] = false;
		}
	}
	
	public boolean resultsContain(List<Integer> result) {
		for(List<Integer> r : results) {
			int flag = 0;
			for(Integer num : r) {
				if(result.contains(num)) 
					flag++;
			}
			if(flag == 4)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		FourSum_18 fs = new FourSum_18();
		int[] nums = {0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
		fs.fourSum(nums, 6);
		System.out.println(fs.results);
	}

}
