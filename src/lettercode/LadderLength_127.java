package lettercode;

import java.util.ArrayList;
import java.util.List;

public class LadderLength_127 {
	int result = 0;
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		dfs(beginWord,endWord,2,wordList);
		return result;
	}
	
	public void dfs(String beginWord, String endWord,int len, List<String> wordList) {
		if(beginWord.equals(endWord)) {
			result = len;
			return;
		}
		for(int i = 0;i < beginWord.length();i++) {
			if(beginWord.charAt(i) != endWord.charAt(i)) {
				String tempWord = beginWord.substring(0, i) + endWord.charAt(i) + beginWord.substring(i + 1);
				boolean flag = false;
				for(String wordListStr : wordList) {
					if(tempWord.equals(wordListStr)) {
						flag = true;
						break;
					}
				}
				if(flag == true) {
					if(result == 0)
						dfs(tempWord,endWord,++len,wordList);
				}
			}
		}
	}

	public static void main(String[] args) {
		LadderLength_127 ll = new LadderLength_127();
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		ll.ladderLength("hit", "cog",wordList );

	}

}
