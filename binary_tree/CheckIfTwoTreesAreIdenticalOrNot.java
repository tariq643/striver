package dsa.striver.binary_tree;

public class CheckIfTwoTreesAreIdenticalOrNot {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //your code goes here

        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }

        if (p.data != q.data) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
