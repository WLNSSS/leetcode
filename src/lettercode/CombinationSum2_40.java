package lettercode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2_40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		solution(result,new ArrayList<Integer>(),candidates,0,target);
		return result;
    }
	
	private void solution(List<List<Integer>> result,List<Integer> layerResult,int[] candidates, int start,int target) {
		if(target == 0) {
			result.add(layerResult);
			return;
		}
		for(int i = start;i < candidates.length;i++) {
			if(candidates[i] > target)
				continue;
			List<Integer> newLayerResult = new ArrayList<>(layerResult);
			newLayerResult.add(candidates[i]);
			int[] newCandidates = removeArrByIndex(candidates,i);
			solution(result,newLayerResult,newCandidates,i + 1,target - candidates[i]);
		}
		
	}
	
	public int[] removeArrByIndex(int[] candidates,int index) {
		int newCandidatesLength = candidates.length - 1;
		int[] newCandidates = new int[newCandidatesLength];
		for(int i = 0;i < newCandidatesLength;i++) {
			if(i < index) {
				newCandidates[i] = candidates[i];
			}else{
				newCandidates[i] = candidates[i + 1];
			}
		}
		return newCandidates;
	}
	
	public static void main(String[] args) {
		CombinationSum2_40 cbss = new CombinationSum2_40();
		int[] a = {10,1,2,7,6,1,5};
//		int[] b = cbss.removeArrByIndex(a, 1);
		int target = 8;
		List<List<Integer>> finalResult = cbss.combinationSum2(a, target);
		for(List<Integer> firstList: finalResult) {
			for(int result : firstList) {
				System.out.print(result + ",");
			}
			System.out.println();
		}
	}

}
