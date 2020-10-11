package lettercode;

public class CanPartition_416 {

	int numsSum = 0;
	boolean exits = false;
	public boolean canPartition(int[] nums) {
		int numsLen = nums.length;
		boolean usedNums[] = new boolean[numsLen];
		for(int num : nums) 
			this.numsSum += num;
		for(int i = 1;i < numsLen;i++) {
			if(exits)
				break;
			dfs(nums,usedNums,0,i);
		}
		return this.exits;
			
    }
	
	public void dfs(int[] nums,boolean[] usedNums,int rightSum,int rArrLen) {
		if(this.exits == true)
			return;
		if(rArrLen == 0) {
			if(numsSum - rightSum == rightSum)
				this.exits = true;
			return;
		}
		int numsLen = nums.length;
		for(int i = 0;i < numsLen;i++) {
			if(!usedNums[i]) {
				rightSum += nums[i];
				usedNums[i] = true;
				rArrLen--;
				dfs(nums,usedNums,rightSum,rArrLen);
				if(exits)
					break;
				rightSum -= nums[i];
				usedNums[i] = false;
				rArrLen++;
			}
		}
	}
	
	public static void main(String[] args) {
		CanPartition_416 c = new  CanPartition_416();
		int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
		c.canPartition(nums);
		System.out.println(c.exits);

	}

}
