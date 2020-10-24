package lettercode;

public class IsLongPressedName_925 {
	public boolean isLongPressedName(String name, String typed) {
		for(int i = 0,j = 0;i < typed.length();i++) {
			if(typed.charAt(i) != name.charAt(j) && typed.charAt(i) == name.charAt(j - 1)) {
				
			}else if(typed.charAt(i) == name.charAt(j)) {
				if(j + 1 != name.length())
					j++;
			}else {
				return false;
			}
		}
		return true;
    }
	public static void main(String[] args) {
		IsLongPressedName_925 ilp = new IsLongPressedName_925();
		ilp.isLongPressedName("vtkgn", "vttkgnn");

	}

}
