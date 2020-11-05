package lettercode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Intersection_349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> tempResult = new LinkedHashSet<Integer>();
		for(int i = 0;i < nums1.length;i++) {
			boolean flag = false;
			for(int j = 0;j < nums2.length;j++) {
				if(nums1[i] == nums2[j]) {
					tempResult.add(nums2[j]);
					break;
				}
			}
		}
		Integer[] result = tempResult.toArray(new Integer[tempResult.size()]);
		return Arrays.stream(result).mapToInt(Integer::valueOf).toArray();
    }
}
