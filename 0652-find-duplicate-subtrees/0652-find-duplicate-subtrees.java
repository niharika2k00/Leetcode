/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getSubtreeString(TreeNode root, HashMap<String, Integer> mp, ArrayList<TreeNode> res) {
        if(root == null)
            return "N";
        
        String str = Integer.toString(root.val) + "," + getSubtreeString(root.left, mp, res) + "," + getSubtreeString(root.right, mp, res);
        System.out.println(str);

        if(mp.containsKey(str)){
            if(mp.get(str) == 1)
                res.add(root);
        }

        mp.put(str,mp.getOrDefault(str,0)+1); // mp[str]++;
        return str;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        // List<TreeNode>res;
        //  List<TreeNode> res = new ArrayList<>();
        ArrayList<TreeNode> res= new ArrayList<>(); // list of dublicate nodes 

        getSubtreeString(root, mp, res);
        return res;       
    }
}

/*
    Intuition : 
    Create the subtree string and store into a hashMap.
    Next time check whether newly created string is present inside the hashMap or not.
    If yes then push it into a vector.
*/
