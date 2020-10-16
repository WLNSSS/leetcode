package lettercode;

public class SortedSquares_977 {
	public int[] sortedSquares(int[] A) {
		int ALen = A.length;
		for(int i = 0;i < ALen;i++) {
			A[i] *= A[i];
			for(int j = i - 1;j >= 0;j--) {
				if(A[j] > A[j + 1]) {
					int tempNum = A[j];
					A[j] = A[j + 1];
					A[j + 1] = tempNum;
				}else {
					break;
				}
			}
		}
		return A;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
