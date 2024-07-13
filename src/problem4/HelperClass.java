package problem4;

public class HelperClass {
	public String serialize(TreeNode node) {
		StringBuilder str=new StringBuilder();
		serializeHelper(node, str);
		return str.toString();
	}
	
	public void serializeHelper(TreeNode node,StringBuilder str) {
		if(node==null) {
			str.append("#,");
			return;
		}
		str.append(node.val).append(",");
		serializeHelper(node.left, str);
		serializeHelper(node.right, str);
	}
	
	public TreeNode deserialize(String res) {
		 int []index=new int[] {0};
		 String[]arr=res.split(",");
		 return deserializeHelper(arr, index);
	}
	
	public TreeNode deserializeHelper(String[] arr,int []index) {
		if(index[0]>arr.length || arr[index[0]].equals("#")) {
			index[0]++;
			return null;
		}
		TreeNode node=new TreeNode(Integer.parseInt(arr[index[0]]));
		index[0]++;
		node.left=deserializeHelper(arr, index);
		node.right=deserializeHelper(arr,index);
		return node;
	}
}
