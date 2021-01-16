package lettercode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindRedundantConnection_684 {
	public int[] findRedundantConnection(int[][] edges) {
		int[] result = new int[2];
		Set<Integer> point = new HashSet<>();
		for(int[] edge : edges) {
			for(int p : edge) {
				point.add(p);
			}
		}
		int pointLen = point.size();
		int[][] pointArr = new int[pointLen][pointLen];
		for(int[] edge : edges) {
			pointArr[edge[0] - 1][edge[1] - 1] = 1;
			pointArr[edge[1] - 1][edge[0] - 1] = 1;
		}
		for(int i = 0;i < pointArr.length;i++) {
			pointArr[i][i] = 1;
		}
		for(int i = edges.length - 1;i >= 0;i--) {
			int[] edge = edges[i];
			int[][] temp = new int[pointLen][pointLen];
			for(int k = 0;k < temp.length;k++){
				temp[k] = pointArr[k].clone();
	        }
			temp[edge[0] - 1][edge[1] - 1] = 0;
			temp[edge[1] - 1][edge[0] - 1] = 0;
			if(isConnect(temp)) {
				result[0] = edge[0];
				result[1] = edge[1];
				break;
			}
		}
		return result;
    }
	public boolean isConnect(int[][] isConnected) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		
		while(!queue.isEmpty()) {
			Integer start = queue.poll();
			isConnected[start][start] = 0;
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[start][j] == 1) {
					queue.add(j);
					isConnected[start][j] = 0;
					isConnected[j][start] = 0;
				}
			}
		}
		boolean result = true;
		for(int i = 0;i < isConnected.length;i++) {
			for(int j = 0;j < isConnected.length;j++) {
				if(isConnected[i][j] == 1) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		FindRedundantConnection_684 frc = new FindRedundantConnection_684();
		int[][] edges = {{1,3},{3,4},{1,5},{3,5},{2,3}};
		int[] result = frc.findRedundantConnection(edges);
		System.out.println(result[0] + "," + result[1]);
	}
}
