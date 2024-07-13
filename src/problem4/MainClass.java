package problem4;

import java.util.Arrays;

public class MainClass {
	public static void main(String[]args) {
		HelperClass helperClass=new HelperClass();
		
		TreeNode root=new TreeNode(10);
		root.left=new TreeNode(20);
		root.right=new TreeNode(30);
		root.left.left=new TreeNode(40);
		root.left.right=new TreeNode(50);
		root.right.left=new TreeNode(60);
		root.right.right=new TreeNode(70);
		
		String encoded= helperClass.serialize(root);
		System.out.println("Tree encoded to String : "+ encoded);
		
		TreeNode decoded=helperClass.deserialize(encoded);
		System.out.println("Root val after decoding : "+decoded.val);
	}
}
