package lettercode;

import java.util.HashSet;

public class TotalNQueens_52 {
	int result = 0;
	int[][][] resultTable;
	int resultTableIndex = 0;
	public int totalNQueens(int n) {
		int[][] table = new int[n][n];
		resultTable = new int[1000][n][n];
		dfs(n,table,1);
		return result;
    }
	public void dfs(int n,int[][] table,int pieceNum) {
		if(pieceNum == n + 1) {
			if(resultTableIndex == 0 || !isExists(n,table)) {
				result++;
				for(int i = 0;i < n;i++)
					resultTable[resultTableIndex][i] = table[i].clone();
				resultTableIndex++;
			}
			return;
		}
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				if(table[i][j] == 0) {
					markTable(table,i,j,true,n,pieceNum);
//					printTable(n,table);
					dfs(n,table,++pieceNum);
					--pieceNum;
					markTable(table,i,j,false,n,pieceNum);
//					printTable(n,table);
					break;
				}
			}
		}
	}
	public void markTable(int[][] table,int i,int j,boolean flag,int n,int pieceNum) {
		if(flag == true) {
			for(int k = 0;k < n;k++) {
				//横竖走法标记
				if(table[i][k] == 0) 
					table[i][k] = pieceNum;
				if(table[k][j] == 0) 
					table[k][j] = pieceNum;
				//斜走法
				if(i - k >= 0 && j - k >= 0) {
					if(table[i - k][j - k] == 0)
						table[i - k][j - k] = pieceNum;
				}
				if(i + k < n && j + k < n) {
					if(table[i + k][j + k] == 0)
						table[i + k][j + k] = pieceNum;
				}
				if(i - k >= 0 && j + k < n) {
					if(table[i - k][j + k] == 0)
						table[i - k][j + k] = pieceNum;
				}
				if(i + k < n && j - k >= 0) {
					if(table[i + k][j - k] == 0)
						table[i + k][j - k] = pieceNum;
				}
			}
		}else {
			for(int k = 0;k < n;k++) {
				//横竖走法标记
				if(table[i][k] == pieceNum) 
					table[i][k] = 0;
				if(table[k][j] == pieceNum) 
					table[k][j] = 0;
				//斜走法
				if(i - k >= 0 && j - k >= 0) {
					if(table[i - k][j - k] == pieceNum)
						table[i - k][j - k] = 0;
				}
				if(i + k < n && j + k < n) {
					if(table[i + k][j + k] == pieceNum)
						table[i + k][j + k] = 0;
				}
				if(i - k >= 0 && j + k < n) {
					if(table[i - k][j + k] == pieceNum)
						table[i - k][j + k] = 0;
				}
				if(i + k < n && j - k >= 0) {
					if(table[i + k][j - k] == pieceNum)
						table[i + k][j - k] = 0;
				}
			}
			
		}
		
		if(flag == true) {
			table[i][j] = -1;
		}else {
			table[i][j] = 0;
		}
	}
	public boolean isExists(int n,int[][] table) {
		for(int i = 0;i < this.resultTableIndex;i++) {
			int flag = 0;
			for(int j = 0;j < n;j++) {
				for(int k = 0;k < n;k++) {
					if(table[j][k] == -1 && table[j][k] == this.resultTable[i][j][k]) {
						flag++;
						break;
					}
				}
			}
			if(flag == n)
				return true;
		}
		return false;
	}
	public void printTable(int n,int[][] table) {
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				System.out.print(table[i][j] + " ");;
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	private static String ms2DHMS(long startMs, long endMs) {
        String retval = null;
        long secondCount = (endMs - startMs) / 1000;
        String ms = (endMs - startMs) % 1000 + "ms";

        long days = secondCount / (60 * 60 * 24);
        long hours = (secondCount % (60 * 60 * 24)) / (60 * 60);
        long minutes = (secondCount % (60 * 60)) / 60;
        long seconds = secondCount % 60;

        if (days > 0) {
            retval = days + "d" + hours + "h" + minutes + "m" + seconds + "s";
        } else if (hours > 0) {
            retval = hours + "h" + minutes + "m" + seconds + "s";
        } else if (minutes > 0) {
            retval = minutes + "m" + seconds + "s";
        } else if(seconds > 0) {
            retval = seconds + "s";
        }else {
            return ms;
        }

        return retval + ms;
    }
	public static void main(String[] args) {
		TotalNQueens_52 tnq = new TotalNQueens_52();
		long startTime =  System.currentTimeMillis();
		System.out.println(tnq.totalNQueens(9));
		long endTime =  System.currentTimeMillis();
		System.out.println("Time elapsed:"+ms2DHMS(startTime,endTime));

	}

}
