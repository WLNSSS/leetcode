package lettercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge_721 {
	// ����һ���ַ�����ӳ��洢���鼯
    Map<String, String> q;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        q = new HashMap<>();
        // ���ӳ��洢ÿ�������Ӧ�˻�������
        Map<String, String> names = new HashMap<>();

        // ���������˻��������鼯
        for(List<String> a : accounts) {
            for(int i = 1; i < a.size(); i++) {
                if(!q.containsKey(a.get(i))){
                    // ������鼯��û��������䣬��������䣬���Ԫ�ؾ��Ǳ���
                    q.put(a.get(i), a.get(i));
                    // ��Ӹ������Ӧ���˻���
                    names.put(a.get(i), a.get(0));
                } 

                if(i > 1) {
                    // ���鼯�ĺϲ��������ϲ�һ���˻��е���������
                    q.put(find(a.get(i)), find(a.get(i - 1)));
                }
            }
        }

        // ��ʱ�洢���е������б�ÿ����ֵ�Եļ�����ÿ�����鼯���ϵĸ�Ԫ��
        Map<String, List<String>> temp = new HashMap<>();
        for(String email : q.keySet()) {
            // ��ȡ��ǰ�����Ӧ���鼯�ĸ�Ԫ��
            String root = find(email);
            // ����ǰ��������Ԫ�ض�Ӧ���б���
            if(!temp.containsKey(root)) temp.put(root, new ArrayList<>());
            temp.get(root).add(email);
        }

        List<List<String>> res = new ArrayList();
        // ���𰸴�ӳ���зŵ��б���
        for(String root : temp.keySet()) {
            // ��ȡ��ǰ��Ԫ�ض�Ӧ���б�
            List<String> layer = temp.get(root);      
            // ��ĿҪ�������
            Collections.sort(layer);
            // �������
            layer.add(0, names.get(root));
            // ����ǰ�б�����
            res.add(layer);
        }

        return res;
    }

    // ���鼯����ģ�庯�����������ַ����滻��֮ǰ������
    private String find(String x) {
        if(!q.get(x).equals(x)) {
            q.put(x, find(q.get(x)));
        }

        return q.get(x);
    }
}
