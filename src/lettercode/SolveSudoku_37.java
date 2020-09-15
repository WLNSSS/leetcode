package lettercode;

public class SolveSudoku_37 {

	public void solveSudoku(char[][] board) {
		dfs(board);
    }
	
	public boolean dfs(char[][] board) {
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				if(board[i][j] == '.') {
					boolean flag = false;
					for(int k = 1;k < 10;k++) {
						if(check(board,k,i,j)) {
							board[i][j] = (char)(k+48);
							if(dfs(board)) {
								flag = true;
								return true;
							}
						}
					}
					if(!flag) {
						board[i][j] = '.';
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean check(char[][] board,int val,int x,int y) {
		//ÅÐ¶ÏÐÐ¡¢ÁÐ
        for(int j = 0;j < 9;j++){
            if(board[x][j] == (char)(val+48) || board[j][y] == (char)(val+48)) return false;
        }
        //ÅÐ¶Ï3*3·½Õó
        int posX = x/3*3;
        int posY = y/3*3;
        for(int i = posX;i < posX+3;i++){
            for(int j = posY;j < posY+3;j++){
                if(board[i][j] == (char)(val+48)) 
                    return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
						  {'6','.','.','1','9','5','.','.','.'},
						  {'.','9','8','.','.','.','.','6','.'},
						  {'8','.','.','.','6','.','.','.','3'},
						  {'4','.','.','8','.','3','.','.','1'},
						  {'7','.','.','.','2','.','.','.','6'},
						  {'.','6','.','.','.','.','2','8','.'},
						  {'.','.','.','4','1','9','.','.','5'},
						  {'.','.','.','.','8','.','.','7','9'},};
		SolveSudoku_37 ss = new SolveSudoku_37();
		ss.solveSudoku(board);

	}

}
