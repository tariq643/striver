package dsa.striver.binary_tree.constructionProblems;

public class RequirementsneededtoconstructauniqueBT {

    public boolean uniqueBinaryTree(int a, int b) {
        //your code goes here
        return !(a == b || (a == 1 && b == 3) || (a == 3 && b == 1));

    }
}
