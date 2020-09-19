package lettercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique_47 {

    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums,0);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    
    private void dfs(int[] nums,int cur) {
        if (cur == nums.length) {
            List<Integer> line = new ArrayList<>();
            for (int i : nums) {
                line.add(i);
            }
            set.add(line);
        } else {
            for (int i = cur;i < nums.length;i++) {
                swap(nums,cur,i);
                dfs(nums,cur + 1);
                swap(nums,cur,i);
            }
        }
    }
    
    private void swap(int nums[],int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
