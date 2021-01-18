package lettercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge_721 {
	// 利用一个字符串的映射存储并查集
    Map<String, String> q;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        q = new HashMap<>();
        // 这个映射存储每个邮箱对应账户的名字
        Map<String, String> names = new HashMap<>();

        // 遍历所有账户构建并查集
        for(List<String> a : accounts) {
            for(int i = 1; i < a.size(); i++) {
                if(!q.containsKey(a.get(i))){
                    // 如果并查集中没有这个邮箱，则添加邮箱，其根元素就是本身
                    q.put(a.get(i), a.get(i));
                    // 添加该邮箱对应的账户名
                    names.put(a.get(i), a.get(0));
                } 

                if(i > 1) {
                    // 并查集的合并操作，合并一个账户中的所有邮箱
                    q.put(find(a.get(i)), find(a.get(i - 1)));
                }
            }
        }

        // 暂时存储答案中的邮箱列表，每个键值对的键就是每个并查集集合的根元素
        Map<String, List<String>> temp = new HashMap<>();
        for(String email : q.keySet()) {
            // 获取当前邮箱对应并查集的根元素
            String root = find(email);
            // 将当前邮箱放入根元素对应的列表中
            if(!temp.containsKey(root)) temp.put(root, new ArrayList<>());
            temp.get(root).add(email);
        }

        List<List<String>> res = new ArrayList();
        // 将答案从映射中放到列表总
        for(String root : temp.keySet()) {
            // 获取当前根元素对应的列表
            List<String> layer = temp.get(root);      
            // 题目要求的排序
            Collections.sort(layer);
            // 添加姓名
            layer.add(0, names.get(root));
            // 将当前列表加入答案
            res.add(layer);
        }

        return res;
    }

    // 并查集查找模板函数，这里用字符串替换了之前的整型
    private String find(String x) {
        if(!q.get(x).equals(x)) {
            q.put(x, find(q.get(x)));
        }

        return q.get(x);
    }
}
