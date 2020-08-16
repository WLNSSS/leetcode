package lettercode;

public class RemoveBoxsSolution {
	
	static int maxData = 0;
	public int removeBoxes(int[] boxes) {
		solution(boxes,0);
		return maxData;
    }
	
	public void solution(int[] boxes,int preResult) {
		int boxesLength = boxes.length;
		for(int i = 0;i < boxesLength;i++) {
			int currentData = boxes[i];
			int length = 1;
			//sample length
			for(int j = i+1;j < boxesLength;j++) {
				if(currentData == boxes[j]) {
					length++;
				}else {
					break;
				}
			}
			//new Array
			int newBoxesLength = boxesLength - length;
			int[] newBoxes = new int[newBoxesLength];
			for(int j = 0,k = i;j < newBoxesLength;j++) {
				if(j >= k){
					newBoxes[j] = boxes[j + length];
				}else {
					newBoxes[j] = boxes[j];
				}
			}
			
			int result = preResult + length * length;
			if(newBoxesLength == 0) {
				maxData = (maxData > result) ? maxData : result;
			}else {
				//recursion
				solution(newBoxes,preResult + length * length);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] boxes = {3,8,8,5,5,3,3,3,3,3,3,3,3,3,6,2,3,8,9,1};
		RemoveBoxsSolution instance = new RemoveBoxsSolution();
		System.out.println(instance.removeBoxes(boxes));	
	}
}
