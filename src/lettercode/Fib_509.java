package lettercode;

public class Fib_509 {
	public int fib(int n) {
		int[] memoery = new int[n + 1];
		return recur(n,memoery);
    }
	public int recur(int n,int[] memoery) {
		if(n == 0) 
			return 0;
		if(n == 1)
			return 1;
		if(memoery[n] == 0) {
			memoery[n] = fib(n - 1) + fib(n - 2);
			return memoery[n];
		}else {
			return memoery[n];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
