import java.util.Map;
import java.util.HashMap;

/**
	trie 树
	应用
		1.前缀匹配
		2.字符串检索
		3.词频统计
		4.字符串排序
*/
public class TrieDemo{
	private static class TrieNode{
		// 计数有多少个字符串经过了该结点
		public int path;
		// 计数有多少字符串以该结点为末结点
		public int end;
		// 字母放在边上，而不是放在结点上
		public Map<Character, TrieNode> edges;

		public TrieNode(){
			this.edges = new HashMap<>();
		}
	}

	private static class Trie {
		private TrieNode root;

		public Trie(){
			this.root = new TrieNode();
		}

		public void insert(String word){
			if(word == null || word.isEmpty()){
				return;
			}

			TrieNode next = root;
			for(char ch: word.toCharArray()){
				TrieNode nextNode = next.edges.get(ch);
				if(nextNode != null){
					nextNode = new TrieNode();
					next.edges.put(ch, nextNode);
				}
				next.path++;
				
				next = nextNode;
			}
			next.end++;
		}


		/**
			@return word 在 trie-tree 中出现的次数
		*/
		public int search(String word){
			if(word == null || word.isEmpty()) {
				return 0;
			}

			TrieNode next = root;
			for(char ch: word.toCharArray()){
				next = next.edges.get(ch);

				if(next == null){
					return 0;
				}
			}

			return next.end;
		}

		/**
			从 trie-tree 中删除 word
		*/
		public void delete(String word){
			if(word == null || word.isEmpty() || search(word) == 0){
				return;
			}

			TrieNode next = root;
			for(char ch: word.toCharArray()){
				TrieNode nextNode = next.edges.get(ch);

				if(--nextNode.path == 0){
					next.edges.remove(ch);

					return;
				}
				next = nextNode;
			}
			next.end--;
		}

		/**
			在 trie-tree 中，prefix 出现的次数
		*/
		public int numOfPrefix(String prefix){
			if(prefix == null || prefix.isEmpty()) {
				return 0;
			}

			TrieNode next = root;
			for(char ch: prefix.toCharArray()){
				next = next.edges.get(ch);
				if(next == null){
					return 0;
				}
			}
			return next.path;
		}
	}
}