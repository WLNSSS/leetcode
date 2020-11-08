package lettercode;

public class CountRangeSum_327 {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int result = 0;
		for(int i = 0;i < nums.length;i++) {
			long sum = nums[i];
			if(sum >= lower && sum <= upper) 
				result++;
			for(int j = i + 1;j < nums.length;j++) {
				sum += nums[j];
				if(sum >= lower && sum <= upper) 
					result++;
			}
		}
		return result;
    }
	public static void main(String[] args) {
		CountRangeSum_327 crs = new CountRangeSum_327();
		int[] nums = {-2147483647,0,-2147483647,2147483647};
		crs.countRangeSum(nums, -564, 3864);
	}
}
