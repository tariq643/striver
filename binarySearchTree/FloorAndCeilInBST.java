package dsa.striver.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class FloorAndCeilInBST {

    private int floorOfBST (TreeNode root, int key) {

        int floor = -1;
        TreeNode current = root;
        while (current != null) {
            if (current.data == key) {
                floor = key;
                break;
            }
            else if (current.data < key) {
                floor = current.data;
                current = current.right;
            }
            else {
                current = current.left;
            }
        }
        return floor;
    }

    private int ceilOfBST (TreeNode root, int key) {

        int ceil = -1;
        TreeNode current = root;
        while (current != null) {
            if (current.data == key) {
                ceil = key;
                break;
            }
            else if (current.data > key) {
                ceil = current.data;
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return ceil;
    }

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
        List<Integer> result = new ArrayList<>();
        result.add(this.floorOfBST(root, key));
        result.add(this.ceilOfBST(root, key));
        return result;
    }

}
