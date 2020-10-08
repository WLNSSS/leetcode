package lettercode;

public class SortColors {

	public void sortColors(int[] nums) {
		int[] tempArr = new int[3];
		int numsLen = nums.length;
		for(int i = 0;i < numsLen;i++) {
			switch(nums[i]) {
				case 0 : tempArr[0]++;break;
				case 1 : tempArr[1]++;break;
				case 2 : tempArr[2]++;break;
			}
		}
		for(int i = 0,j = 0;i < 3;) {
			if(tempArr[i] == 0) {
				i++;
				continue;
			}
			nums[j] = i;
			j++;
			tempArr[i]--;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
