package lettercode;

public class MinimumEffortPath_1631 {
	int result = 0;
	public int minimumEffortPath(int[][] heights) {
		boolean[][] heightsState = new boolean[heights.length][heights[0].length];
		
    }
	public void dfs(int[][] heights,boolean[][] heightsState,int currentResult,int i,int j,int preValue) {
		int currentGap = Math.abs(heights[i][j] - preValue);
		if(currentGap < currentResult) {
			currentResult = currentGap;
		}
		if(i == heights.length - 1 && j == heights[0].length - 1) {
			if(currentResult < this.result) {
				this.result = currentResult;
			}
			return;
		}
		if(i != 0 && heightsState[i - 1][j] != true) {
			
		}
	}
}
