package lettercode;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern_459 {
	public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        List<Integer> maybeList = new ArrayList<Integer>();
        int halfN = n / 2;
        //�����Ǳ����п��ܵ��Ӵ�����List,��Ҫ�ǿ��ܷ�������������15���ַ����ַ������ִ��ض���������2��4��6��7
        for(int i = 1;i <= halfN;i++) {
        	if(!(((double)n / i) != (n / i))) {
        		maybeList.add(i);
        	}
        }
        for(Integer index : maybeList) {
        	String str = s;
        	str = str.replace(s.substring(0,index), "");
        	if(str.isEmpty())
        		return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		RepeatedSubstringPattern_459 r = new RepeatedSubstringPattern_459();
		r.repeatedSubstringPattern("ababa");
	}

}
