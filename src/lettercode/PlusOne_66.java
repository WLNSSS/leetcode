package lettercode;

import java.util.Arrays;

public class PlusOne_66 {

	public int[] plusOne(int[] digits) {
		int index = digits.length - 1;
		while(true) {
			if(digits[index] + 1 != 10) {
				digits[index] += 1 ;
				break;
			}else {
				digits[index] = 0;
				index--;
				if(index == -1) {
					int[] newDigits = new int[1 + digits.length];
					int[] tempArr = {1};
					System.arraycopy(tempArr, 0 , newDigits, 0, 1);
					System.arraycopy(digits, 0 , newDigits, 1, digits.length);
					return newDigits;
				}
			}
		}
		return digits;
    }
	
	public static void main(String[] args) {
		PlusOne_66 po = new PlusOne_66();
		int[] arr = {9,9,9};
		po.plusOne(arr);

	}

}
