package interviewBit.trees;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class NextGreatestNumberBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode getSuccessor(TreeNode a, int b) {
		return getSuccessorRec(a, a.right, b);
	}
	
	public TreeNode getSuccessorRec(TreeNode a,TreeNode ans, int b) {
		if(a.val==b)
		{
			return ans;
		}
		else if(a.val<b)
		{
			return getSuccessorRec(a.right, ans.right, b);
		}
		else
		{
			return getSuccessorRec(a.left, a, b);
		}
	}

}
