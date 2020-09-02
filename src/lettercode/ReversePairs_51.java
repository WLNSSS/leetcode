package lettercode;

public class ReversePairs_51 {
	
	public int reversePairs(int[] nums) {
		int numsLength = nums.length;
		int result = 0;
		for(int i = 0;i < numsLength;i++)
			for(int j = i + 1;j < numsLength;j++)
				if(nums[i] > nums[j])
					result++;
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
