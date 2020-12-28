package lettercode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxProfit_188 {
	
	public int maxProfit(int[] prices) {
		int pLen = prices.length;
		if(pLen <= 1) {
			return 0;
		}
		int[] tempPrices = new int[pLen - 1];
		tempPrices[0] = 0;
		for(int i = 1;i < prices.length;i++) {
			tempPrices[i - 1] = prices[i] - prices[i - 1];
		}
		Map<String,Integer> tempResult = recur(tempPrices,0,pLen - 2);
//		int leftResult = 0;
//		if(tempResult.get("curPreIndex") - 1 >= 0)
//			leftResult = recur(tempPrices,0,tempResult.get("curPreIndex") - 1).get("max");
//		int rightResult = 0;
//		if(tempResult.get("curLastIndex") + 1 <= pLen - 2)
//			rightResult = recur(tempPrices,tempResult.get("curLastIndex") + 1,pLen - 2).get("max");
//		int secondResult = leftResult > rightResult ? leftResult : rightResult;
//		secondResult = secondResult < 0 ? 0 : secondResult;
		int secondResult = 0;
		return (tempResult.get("max") + secondResult) < 0 ? 0 : (tempResult.get("max") + secondResult);
    }
	
	public Map<String,Integer> recur(int[] dealPrices,int curPreIndex,int curLastIndex) {
		Map<String,Integer> result = new HashMap<String, Integer>();
		if(curPreIndex == curLastIndex) {
			result.put("max", dealPrices[curPreIndex]);
			result.put("curPreIndex",curPreIndex);
			result.put("curLastIndex",curLastIndex);
			return result;
		}
		//处理左边
		int left_max,left_preIndex,left_lastIndex;
		Map<String,Integer> leftResult = recur(dealPrices,curPreIndex,(curLastIndex + curPreIndex) / 2);
		left_max = leftResult.get("max");
		left_preIndex = leftResult.get("curPreIndex");
		left_lastIndex = leftResult.get("curLastIndex");
		//处理右边
		int right_max,right_preIndex,right_lastIndex;
		Map<String,Integer> rightResult = recur(dealPrices,(curLastIndex + curPreIndex) / 2 + 1,curLastIndex);
		right_max = rightResult.get("max");
		right_preIndex = rightResult.get("curPreIndex");
		right_lastIndex = rightResult.get("curLastIndex");
		//处理跨越中点的情况
		int cross_max,cross_preIndex,cross_lastIndex;
		Map<String,Integer> crossResult = findCrossMiddle(dealPrices,curPreIndex,curLastIndex);
		cross_max = crossResult.get("max");
		cross_preIndex = crossResult.get("curPreIndex");
		cross_lastIndex = crossResult.get("curLastIndex");
		if(left_max >= cross_max && left_max >= right_max) {
			result.put("max", left_max);
			result.put("curPreIndex",left_preIndex);
			result.put("curLastIndex",left_lastIndex);
		}else if(right_max >= cross_max && left_max <= right_max) {
			result.put("max", right_max);
			result.put("curPreIndex",right_preIndex);
			result.put("curLastIndex",right_lastIndex);
		}else {
			result.put("max", cross_max);
			result.put("curPreIndex",cross_preIndex);
			result.put("curLastIndex",cross_lastIndex);
		}
		return result;
	}
	
	public Map<String,Integer> findCrossMiddle(int[] dealPrices,int curPreIndex,int curLastIndex) {
		int middle = (curLastIndex + curPreIndex) / 2;
		int left_max = 0,left_index = middle,sum = 0;
		for(int i = middle - 1;i >= curPreIndex;i--) {
			sum += dealPrices[i];
			if(sum > left_max) {
				left_max = sum;
				left_index = i;
			} 
		}
		sum = 0;
		int right_max = 0,right_index = middle;
		for(int i = middle + 1;i <= curLastIndex;i++) {
			sum += dealPrices[i];
			if(sum > right_max) {
				right_max = sum;
				right_index = i;
			} 
		}
		Map<String,Integer> result = new HashMap<String, Integer>();
		result.put("max", left_max + right_max +dealPrices[middle]);
		result.put("curPreIndex",left_index);
		result.put("curLastIndex",right_index);
		return result;
	}
	
	public static void main(String[] args) {
		MaxProfit_188 mp = new MaxProfit_188();
		int[] prices = {6,1,3,2,4,7};
		
		System.out.println(mp.maxProfit(prices));
	}

}
