package problem5;

public class TrieNode {
	TrieNode []nodes;
	boolean isWord;
	
	public TrieNode() {
		// TODO Auto-generated constructor stub
		isWord=false;
		nodes=new TrieNode[26];
		for(int i=0;i<26;i++) {
			nodes[i]=null;
		}
	}
}
