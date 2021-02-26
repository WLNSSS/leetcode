package lettercode;

import java.util.List;

public class FindNumOfValidWords_1178 {
	TrieNode root;

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        root = new TrieNode();
        
        for (String word : words) {
            // �� word �е���ĸ�����ֵ�������ȥ��
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; ++i) {
                if (i == 0 || arr[i] != arr[i - 1]) {
                    sb.append(arr[i]);
                }
            }
            // �����ֵ�����
            add(root, sb.toString());
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            char required = puzzle.charAt(0);
            char[] arr = puzzle.toCharArray();
            Arrays.sort(arr);
            ans.add(find(new String(arr), required, root, 0));
        }
        return ans;
    }

    public void add(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                cur.child[ch - 'a'] = new TrieNode();
            }
            cur = cur.child[ch - 'a'];
        }
        ++cur.frequency;
    }

    // �ڻ��ݵĹ�����ö�� puzzle �������Ӽ���ͳ�ƴ�
    // find(puzzle, required, cur, pos) ��ʾ puzzle ������ĸΪ required, ��ǰ�������ֵ����ϵ� cur �ڵ㣬����׼��ö�� puzzle �ĵ� pos ����ĸ�Ƿ�ѡ�񣨷����Ӽ��У�
    // find �����ķ���ֵ��Ϊ�յ׵�����
    public int find(String puzzle, char required, TrieNode cur, int pos) {
        // �������սڵ㣬���Ϸ������� 0
        if (cur == null) {
            return 0;
        }
        // ���� puzzle ������ϣ������յ׵�����
        if (pos == 7) {
            return cur.frequency;
        }

        // ѡ��� pos ����ĸ
        int ret = find(puzzle, required, cur.child[puzzle.charAt(pos) - 'a'], pos + 1);

        // �� puzzle.charAt(pos) ��Ϊ����ĸʱ�����Բ�ѡ��� pos ����ĸ
        if (puzzle.charAt(pos) != required) {
            ret += find(puzzle, required, cur, pos + 1);
        }

        return ret;
    }
}

class TrieNode {
    int frequency;
    TrieNode[] child;

    public TrieNode() {
        frequency = 0;
        child = new TrieNode[26];
    }
}
