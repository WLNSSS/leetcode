package lettercode;

public class Transpose_867 {
	public int[][] transpose(int[][] matrix) {
		int mRowLen = matrix.length , mLineLen = matrix[0].length;
		int[][] result = new int[mLineLen][mRowLen];
		for(int i  = 0;i < mRowLen;i++) {
			for(int j = 0;j < mLineLen;j++) {
				result[j][i] = matrix[i][j];
			}
		}
		return result;
    }
	public static void main(String[] args) {
		int[][] test = {{1,2,3},{4,5,6}};
		Transpose_867 t = new Transpose_867();
		t.transpose(test);
	}
}
