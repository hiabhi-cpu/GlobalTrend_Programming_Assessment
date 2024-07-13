package problem5;

import java.awt.DisplayMode;
import java.util.Arrays;

public class HelperClass {
	TrieNode root;
	
	
	public HelperClass() {
		this.root = new TrieNode();
	}

	public void insert(String res) {
		 root=insertHelper(root,new StringBuilder(res));
	}
	
	public TrieNode insertHelper(TrieNode node,StringBuilder res) {
		if(res.isEmpty()) {
			TrieNode temp=new TrieNode();
			temp.isWord=true;
			return temp;
		}
		TrieNode temp=new TrieNode();
		node.nodes[res.charAt(0)-97]=insertHelper(temp, res.deleteCharAt(0));
		return node;
	}
	
	public boolean search(String res) {
		return searchHelper(root,new StringBuilder(res));
	}
	
	private boolean searchHelper(TrieNode node, StringBuilder res) {
		// TODO Auto-generated method stub
		if(node==null) {
			return false;
		}
		else if(node.isWord && res.isEmpty()) {
			return true;
		}
		else if(res.isEmpty()) {
			return false;
		}
		return searchHelper(node.nodes[res.charAt(0)-97], res.deleteCharAt(0));
	}
	
	public boolean startsWith(String res) {
		return startsWithHelper(root,new StringBuilder( res));
	}

	private boolean startsWithHelper(TrieNode node, StringBuilder res) {
		if(node==null) {
			return false;
		}
		else if(res.isEmpty()) {
			return true;
		}
		return startsWithHelper(node.nodes[res.charAt(0)-97], res.deleteCharAt(0));
	}

}
