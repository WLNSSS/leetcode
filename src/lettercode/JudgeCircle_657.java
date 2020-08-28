package lettercode;

public class JudgeCircle_657 {

	public boolean judgeCircle(String moves) {
		int[] xyAxies = { 0, 0 };
		char[] movesArr = moves.toCharArray();
		for (char move : movesArr) {
			switch (move) {
			case 'U':
				xyAxies[0] -= 1;
				break;
			case 'D':
				xyAxies[0] += 1;
				break;
			case 'L':
				xyAxies[1] -= 1;
				break;
			case 'R':
				xyAxies[1] += 1;
			default:
				break;
			}
		}
		return xyAxies[0] == 0 && xyAxies[1] == 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
