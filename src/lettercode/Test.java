package lettercode;

public class Test {

	public void testStr(String tesS) {
		String newTes = tesS;
		newTes += "ssss";
	}
	public static void main(String[] args) {
		String str = "sss";
		Test t = new Test();
		t.testStr(str);
		System.out.println(str);
	}

}
