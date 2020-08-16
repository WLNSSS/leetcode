package lettercode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumSolution {
	static List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//		solution(candidates,new ArrayList<Integer>(),target);
//		return finalResult;
		List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
	
	private static void backtrack(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //相当于遍历N叉树的子节点
        for (int i = start; i < candidates.length; i++) {
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i])
                continue;
            //由于在java中List是引用传递，所以这里要重新创建一个
            List<Integer> list = new ArrayList<>(cur);
            list.add(candidates[i]);
            backtrack(result, list, candidates, target - candidates[i], i);
        }
    }
	
	public void solution(int[] candidates, List<Integer> result,int target) {
		if(target == 0) {
			finalResult.add(result);
			return;
		}
		int cLength = candidates.length;
		
		for(int i = 0;i < cLength;i++) {
			if(candidates[i] <= target) {
				List<Integer> newResult = new ArrayList<>(result);
				newResult.add(candidates[i]);
				solution(candidates,newResult,target - candidates[i]);
			}else {
				return;
			}
		}
		
	}
	
	public static void main(String[] args) {
		CombinationSumSolution cbss = new CombinationSumSolution();
		int[] a = {2,3,6,7};
		int target = 7;
		List<List<Integer>> finalResult = cbss.combinationSum(a, target);
		for(List<Integer> firstList: finalResult) {
			for(int result : firstList) {
				System.out.print(result + ",");
			}
			System.out.println();
		}
	}

}
