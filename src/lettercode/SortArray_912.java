package lettercode;

public class SortArray_912 {
	
	public int[] sortArray(int[] nums) {
		BubbleSort(nums);
		return nums;
    }
	
	private void InsertSort(int[] nums) {
		int numsLength = nums.length;
		for(int i = 0;i < numsLength;i++) {
			for(int j = i -1;j >= 0;j--) {
				if(nums[j + 1] < nums[j]) {
					int tempNum = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = tempNum;
				}else {
					break;
				}
			}
		}
	}
	
	private void BubbleSort(int[] nums) {
		int numsLength = nums.length;
		for(int i = 0;i < numsLength;i++) {
			for(int j = numsLength - 1;j >= i && i != 0;j--) {
				if(nums[j] < nums[j - 1]) {
					int tempNum = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tempNum;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {5,2,3,1};
		SortArray_912 sa = new SortArray_912();
		sa.sortArray(nums);
		for(int num : nums)
			System.out.println(num);

	}

}
