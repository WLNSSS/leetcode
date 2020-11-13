package lettercode;

public class SortArrayByParityII_922 {
	public int[] sortArrayByParityII(int[] A) {
		for(int i = 1;i < A.length;i++) {
			if(i % 2 == 0) {
				if(A[i] % 2 != 0) 
					for(int j = i + 1;j < A.length;j++) 
						if(A[j] % 2 == 0) {
							int num = A[j];
							A[j] = A[i];
							A[i] = num;
							break;
						}
			}else {
				if(A[i] % 2 == 0) 
					for(int j = i + 1;j < A.length;j++) 
						if(A[j] % 2 != 0) {
							int num = A[j];
							A[j] = A[i];
							A[i] = num;
							break;
						}
			}
		}
		return A;
    }
}
