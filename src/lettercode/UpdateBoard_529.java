package lettercode;

public class UpdateBoard_529 {

	public char[][] updateBoard(char[][] board, int[] click) {
		if(board[click[0]][click[1]] == 'E') {
			int boomNum = findGroundBoom(board,click);
			if(boomNum == 0) {
				board[click[0]][click[1]] = 'B';
				int rowLength = board.length;
				int colLength = board[0].length;
				//top layer
				if(click[0] - 1 >= 0) {
					if(click[1] - 1 >=0) {
						if(board[click[0] - 1][click[1] - 1] != 'M') {
							int[] index = {click[0] - 1,click[1] - 1};
							updateBoard(board,index);
						}
					}
					if(board[click[0] - 1][click[1]] != 'M') {
						int[] index = {click[0] - 1,click[1]};
						updateBoard(board,index);
					}
					if(click[1] + 1 <= colLength - 1) {
						if(board[click[0] - 1][click[1] + 1] != 'M') {
							int[] index = {click[0] - 1,click[1] + 1};
							updateBoard(board,index);
						}
					}
				}
				//middle layer
				if(click[1] - 1 >=0) {
					if(board[click[0]][click[1] - 1] != 'M') {
						int[] index = {click[0],click[1] - 1};
						updateBoard(board,index);
					}
				}
				if(click[1] + 1 <= colLength - 1) {
					if(board[click[0]][click[1] + 1] != 'M') {
						int[] index = {click[0],click[1] + 1};
						updateBoard(board,index);
					}
				}
				//bottom layer
				if(click[0] + 1 <= rowLength - 1) {
					if(click[1] - 1 >=0) {
						if(board[click[0] + 1][click[1] - 1] != 'M') {
							int[] index = {click[0] + 1,click[1] - 1};
							updateBoard(board,index);
						}
					}
					if(board[click[0] + 1][click[1]] != 'M') {
						int[] index = {click[0] + 1,click[1]};
						updateBoard(board,index);
					}
					if(click[1] + 1 <= colLength - 1) {
						if(board[click[0] + 1][click[1] + 1] != 'M') {
							int[] index = {click[0] + 1,click[1] + 1};
							updateBoard(board,index);
						}
					}
				}
			}else {
				board[click[0]][click[1]] = Integer.toString(boomNum).charAt(0);
			}
		}else if(board[click[0]][click[1]]  == 'M'){
			board[click[0]][click[1]] = 'X';
		}
		return board;
		
    }
	
	public int findGroundBoom(char[][] board,int[] index) {
		int boomNum = 0;
		int rowLength = board.length;
		int colLength = board[0].length;
		//top layer
		if(index[0] - 1 >= 0) {
			if(index[1] - 1 >=0) {
				if(board[index[0] - 1][index[1] - 1] == 'M') {
					boomNum++;
				}
			}
			if(board[index[0] - 1][index[1]] == 'M') {
				boomNum++;
			}
			if(index[1] + 1 <= colLength - 1) {
				if(board[index[0] - 1][index[1] + 1] == 'M') {
					boomNum++;
				}
			}
		}
		//middle layer
		if(index[1] - 1 >=0) {
			if(board[index[0]][index[1] - 1] == 'M') {
				boomNum++;
			}
		}
		if(index[1] + 1 <= colLength - 1) {
			if(board[index[0]][index[1] + 1] == 'M') {
				boomNum++;
			}
		}
		//bottom layer
		if(index[0] + 1 <= rowLength - 1) {
			if(index[1] - 1 >=0) {
				if(board[index[0] + 1][index[1] - 1] == 'M') {
					boomNum++;
				}
			}
			if(board[index[0] + 1][index[1]] == 'M') {
				boomNum++;
			}
			if(index[1] + 1 <= colLength - 1) {
				if(board[index[0] + 1][index[1] + 1] == 'M') {
					boomNum++;
				}
			}
		}
		return boomNum;
	}
	
	public static void main(String[] args) {
		char[][] board= {{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'M', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'},{'E', 'E', 'E', 'E', 'E'}};
		int[] click = {3,0};
		UpdateBoard_529 u = new UpdateBoard_529();
		u.updateBoard(board, click);
		for(char[] first : board) {
			for(char second : first) {
				System.out.print(second + ",");
			}
			System.out.println();
		}
	}

}
