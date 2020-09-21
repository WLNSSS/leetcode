package lettercode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

	List<List<Integer>> results = new ArrayList<List<Integer>>();
	public List<List<Integer>> subsets(int[] nums) {
		boolean[] numsUsed = new boolean[nums.length];
		List<Integer> result = new ArrayList<Integer>();
		dfs(nums,numsUsed,result,0);
		result = new ArrayList<Integer>();
		results.add(result);
		return results;
    }
	
	public void dfs(int[] nums,boolean[] numsUsed,List<Integer> result,int cur) {
		if(result.size() > 0)
			results.add(new ArrayList<>(result));
		int numsLen = nums.length;
		for(int i = cur;i < numsLen;i++) {
			if(!numsUsed[i]) {
				result.add(nums[i]);
				numsUsed[i] = true;
				dfs(nums,numsUsed,result,i + 1);
				numsUsed[i] = false;
				result.remove(result.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Subsets_78 s = new Subsets_78();
		s.subsets(nums);
	}

}
