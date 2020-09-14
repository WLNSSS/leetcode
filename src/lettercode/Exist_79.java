package lettercode;

public class Exist_79 {

	public boolean exist(char[][] board, String word) {
		int boardLen = board.length;
		int inboardLen = board[0].length;
		String[] wordArr = word.split("");
		for(int i = 0;i < boardLen;i++) {
			for(int j = 0;j < inboardLen;j++) {
				if(wordArr[0].equals(board[i][j] + "")) {
					board[i][j] = '.';
					if(dfs(board,i,j,wordArr,1)) {
						return true;
					}
					board[i][j] = wordArr[0].charAt(0);
				}
			}
		}
		return false;
    }
	
	public boolean dfs(char[][] board, int i,int j,String[] wordArr,int wordIndex) {
		if(wordIndex == wordArr.length) {
			return true;
		}
		if(i - 1 != -1) {
			if(wordArr[wordIndex].equals(board[i - 1][j] + "")) {
				board[i - 1][j] = '.';
				if(dfs(board,i - 1,j,wordArr,wordIndex + 1)) {
					return true;
				}else {
					board[i - 1][j] = wordArr[wordIndex].charAt(0);
				}
			}
		}
		if(i + 1 != board.length) {
			if(wordArr[wordIndex].equals(board[i + 1][j] + "")) {
				board[i + 1][j] = '.';
				if(dfs(board,i + 1,j,wordArr,wordIndex + 1)) {
					return true;
				}else {
					board[i + 1][j] = wordArr[wordIndex].charAt(0);
				}
			}
		}
		if(j - 1 != -1) {
			if(wordArr[wordIndex].equals(board[i][j - 1] + "")) {
				board[i][j - 1] = '.';
				if(dfs(board,i,j - 1,wordArr,wordIndex + 1)) {
					return true;
				}else {
					board[i][j - 1] = wordArr[wordIndex].charAt(0);
				}
			}
		}
		if(j + 1 != board[0].length) {
			if(wordArr[wordIndex].equals(board[i][j + 1] + "")) {
				board[i][j + 1] = '.';
				if(dfs(board,i,j + 1,wordArr,wordIndex + 1)) {
					return true;
				}else {
					board[i][j + 1] = wordArr[wordIndex].charAt(0);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		Exist_79 e = new Exist_79();
		e.exist(board, word);
	}

}
