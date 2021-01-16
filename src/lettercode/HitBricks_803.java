package lettercode;

public class HitBricks_803 {
	public int[] hitBricks(int[][] grid, int[][] hits) {
		int[] result = new int[hits.length];
		for(int i = 0;i < hits.length;i++) {
			grid[hits[i][0]][hits[i][1]] = 0;
			result[i] = checkOther(grid);
		}
		return result;
    }
	public int checkOther(int[][] grid) {
		int result = 0;
		for(int i = 1;i < grid.length;i++) {
			for(int j = 0;j < grid[0].length;j++) {
				if(grid[i][j] == 1 && !checkIsFall(grid,new int[] {i,j},new int[] {i,j})) {
						grid[i][j] = 0;
						result++;
				}
			}
		}
		return result;
	}
	public boolean checkIsFall(int[][] grid,int[] point,int[] gridState) {
		if(point[0] == 0 && grid[point[0]][point[1]] == 1) {
			return true;
		}
		if(point[0] != 0 && grid[point[0] - 1][point[1]] == 1 && point[0] - 1 != gridState[0] && point[1] != gridState[1]) {
			int[] newPoint = {point[0] - 1,point[1]};
			return checkIsFall(grid,newPoint,point);
		}
		if(point[0] != grid.length - 1 && grid[point[0] + 1][point[1]] == 1  && point[0] + 1 != gridState[0] && point[1] != gridState[1]) {
			int[] newPoint = {point[0] + 1,point[1]};
			return checkIsFall(grid,newPoint,point);
		}
		if(point[1] != 0 && grid[point[0]][point[1] - 1] == 1 && point[0] != gridState[0] && point[1] - 1 != gridState[1]) {
			int[] newPoint = {point[0],point[1] - 1};
			return checkIsFall(grid,newPoint,point);
		}
		if(point[1] != grid[1].length - 1 && grid[point[0]][point[1] + 1] == 1 && point[0] != gridState[0] && point[1] + 1!= gridState[1]) {
			int[] newPoint = {point[0],point[1] + 1};
			return checkIsFall(grid,newPoint,point);
		}
		return false;
	}
	public static void main(String[] args) {
		HitBricks_803 hb = new HitBricks_803();
		int[][] grid = {{1,0,0,0},{1,1,1,0}};
		int[][] hits = {{1,0}};
		hb.hitBricks(grid, hits);
	}
}
