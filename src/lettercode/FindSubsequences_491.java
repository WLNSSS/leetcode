package lettercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences_491 {

    // ����ȫ�ֱ���������
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        // idx ��ʼ��Ϊ -1����ʼ dfs ������
        dfs(nums, -1, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> curList) {
        // ֻҪ��ǰ�ĵ������г��ȴ��� 1���ͼ��뵽��� res �У�Ȼ����������������е���һ��ֵ��
        if (curList.size() > 1) {
            res.add(new ArrayList<>(curList));
        }

        // �� [idx + 1, nums.length - 1] ��Χ�ڱ��������������е���һ��ֵ��
        // ���� set �� [idx + 1, nums.length - 1] ��Χ�ڵ���ȥ�ء�
        Set<Integer> set = new HashSet<>();
        for (int i = idx + 1; i < nums.length; i++) {
            // 1. ��� set ���Ѿ����� nums[i] ��ͬ��ֵ�ˣ�˵������ nums[i] ������п��ܵĵ�������֮ǰ�Ѿ����ѹ�һ���ˣ����ֹͣ����������
            if (set.contains(nums[i])) { 
                continue;
            }
            set.add(nums[i]);
            // 2. ��� nums[i] >= nums[idx] �Ļ���˵���������µĵ������У���˼��� dfs ��������Ϊ curList �������Ǹ��õģ���˱����� remove Ŷ��
            if (idx == -1 || nums[i] >= nums[idx]) {
                curList.add(nums[i]);
                dfs(nums, i, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

