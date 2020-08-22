package lettercode;

public class AddDigits_258 {

	public int addDigits(int num) {
		int result = solution(num);
		while(result >= 10)
			result = solution(result);
		return result;
    }
	
	public int solution(int num) {
		double flag = num / 10.0;
		if(flag < 1) {
			return num;
		}else {
			return (num % 10) + solution(num / 10); 
		}
	}
	
	public static void main(String[] args) {
		int num = 19;
		AddDigits_258 a = new AddDigits_258();
		System.out.println(a.addDigits(num));

	}

}
