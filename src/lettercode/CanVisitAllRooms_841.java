package lettercode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms_841 {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		if(rooms.size() == 0)
			return false;
		boolean result = true;
		boolean[] roomsFlag = new boolean[rooms.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while(queue .size() != 0) {
			int index = queue.remove();
			if(roomsFlag[index] == false) {
				for(Integer roomKey : rooms.get(index)) {
					queue.offer(roomKey);
				}
			}
			roomsFlag[index] = true;
		}
		for(boolean tempFlag : roomsFlag) 
			if(tempFlag == false)
				result = false;
		return result;
		
    }

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		lists.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(0);
		list.add(1);
		lists.add(list);
		list = new ArrayList<Integer>();
		list.add(2);
		lists.add(list);
		list = new ArrayList<Integer>();
		list.add(0);
		lists.add(list);
		CanVisitAllRooms_841 cvar = new CanVisitAllRooms_841();
		System.out.println(cvar.canVisitAllRooms(lists));

	}

}
