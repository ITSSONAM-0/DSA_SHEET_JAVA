public class KsmallestElement {
    public static void main(String[] args) {
        public void helper(TreeNode node, ArrayList<Integer> ls){
        if(node == null){
            return;
        }
        helper(node.left,ls);
        ls.add(node.val);
        helper(node.right,ls);
    }


    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        helper(root,ls);

        Collections.sort(ls);

       
        int ans = ls.get(k-1);
        return ans;

    }
    }
}
