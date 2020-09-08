package lettercode;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation_60 {
	String resultStr = "";
	int k = 0;
	int numFlag = 0;
	private void dfs(int[] nums,boolean[] numsFlag,List<Integer> result) {
		int numsLen = nums.length;
		if(result.size() == numsLen) {
			numFlag++;
			if(numFlag == k) {
				StringBuffer sb = new StringBuffer();
				for(Integer num : result) {
					sb.append(num);
				}
				resultStr = sb.toString();
			}
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

	public String getPermutation(int n, int k) {
		this.k = k;
		int[] arr = new int[n];
		for(int i = 1;i < n + 1;i++) {
			arr[i - 1] = i;
		}
		boolean[] numsFlag = new boolean[arr.length];
		dfs(arr,numsFlag,new ArrayList<Integer>());
		
		return resultStr;
    }
	
	public static void main(String[] args) {
		GetPermutation_60 gp = new GetPermutation_60();
		System.out.println(gp.getPermutation(3, 3));

	}

}
