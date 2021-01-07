package lettercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindCircleNum_547 {
	int result = 0;

	public int findCircleNum(int[][] isConnected) {
		this.result = isConnected.length;
		for (int i = 0; i < isConnected.length; i++) {
			isConnected[i][i] = 2;
		}
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1) {
					bfs(isConnected,i);
					break;
				}
			}
		}
		return result;
	}

	public void bfs(int[][] isConnected, int from) {
		Set<Integer> seeNode = new HashSet<Integer>();
		seeNode.add(from);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(from);
		while(!queue.isEmpty()) {
			Integer start = queue.poll();
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[start][j] == 1) {
					queue.add(j);
					isConnected[start][j] = 2;
					isConnected[j][start] = 2;
					seeNode.add(j);
				}
			}
		}
		result -= seeNode.size() - 1;
	}

	public static void main(String[] args) {
		FindCircleNum_547 fcn = new FindCircleNum_547();
		int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(fcn.findCircleNum(isConnected));
	}

}
