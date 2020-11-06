package lettercode;

public class SortByBits_1356 {
	public int[] sortByBits(int[] arr) {
		int [] oneArr = new int[arr.length];
		for(int i = 0;i < arr.length;i++) {
			oneArr[i] = recordOne(arr[i]);
		}
		for(int i = 0;i < arr.length;i++) {
			for(int j = arr.length - 1;j > i;j--) {
				if(oneArr[j] < oneArr[j - 1] || (oneArr[j] == oneArr[j - 1] && arr[j] < arr[j - 1])) {
					int num = oneArr[j];
					oneArr[j] = oneArr[j - 1];
					oneArr[j - 1] = num;
					num = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = num;
				}
			}
		}
		return arr;
    }
	public int recordOne(int num) {
		if(num == 0)
			return 0;
		int result = 0;
		while(num != 1) {
			if(num % 2 == 1)
				result++;
			num = num / 2;
		}
		return result + 1;
	}
	public static void main(String[] args) {
		SortByBits_1356 sbb = new SortByBits_1356();
		int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
		sbb.sortByBits(arr);
	}
}
