package lettercode;

public class KClosest_973 {
	public int[][] kClosest(int[][] points, int K) {
		long[] tempPoints = new long[points.length];
		int[][] result = new int[K][2];
		for(int i = 0;i < points.length;i++) {
			tempPoints[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
		}
		for(int i = 0;i < K;i++) {
			for(int j = tempPoints.length - 1;j >= 1;j--) {
				if(tempPoints[j] < tempPoints[j - 1]) {
					long num = tempPoints[j];
					tempPoints[j] = tempPoints[j - 1];
					tempPoints[j - 1] = num;
					int[] numArr = new int[2];
					numArr = points[j];
					points[j] = points[j - 1];
					points[j - 1] = numArr;
				}
			}
			result[i] = points[i];
		}
		return result;
    }
}
