package lettercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test {

	public void testStr(String tesS) {
		String newTes = tesS;
		newTes += "ssss";
	}
	public static void main(String[] args) {
		String str = "sss";
		String str2 = "ss";
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(7);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(7);
		list1.add(1);
		HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
		hs.add(list);
		hs.add(list1);
		System.out.println(hs.contains(list1));
	}

}
