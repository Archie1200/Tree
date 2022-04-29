package TREES;

import java.util.HashMap;
import java.util.Map;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int value;
}
public class Tree {
    static TreeNode root;
    static int sum=0;
    public static TreeNode Insert(TreeNode root,int value){
        TreeNode a = new TreeNode();
        if(root==null){
            a.value=value;
            return a;
        }
        else if(value<root.value){
            root.left=Insert(root.left,value);
        }
        else if(value> root.value){
            root.right=Insert(root.right,value);
        }
        return root;
    }
    public  static  TreeNode insertValue(int value){
        root=Insert(root,value);
        return root;
    }
    public static void InorderTraversal(TreeNode root){
        if(root==null)
            return;
        InorderTraversal(root.left);
        System.out.print(root.value+" ");
        InorderTraversal(root.right);
    }
    public  static  TreeNode greaterSum(TreeNode root){
        if(root!=null){
            greaterSum(root.right);
            sum+=root.value;
            root.value=sum;
            greaterSum(root.left);
        }
        return  root;
    }
    public static int countNodes(TreeNode root){
        if(root==null)
            return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
    public static TreeNode delete(TreeNode root,int value){
        if(root==null){
            return null;
        }
        else if(value<root.value){
            root.left=delete(root.left,value);
        }
        else if(value> root.value){
            root.right=delete(root.right,value);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else{
                int minValue= min(root.right);
                root.value=minValue;
                root.right=delete(root.right,minValue);
            }
        }
        return root;
    }
    //finding Successor
    public  static int min(TreeNode root){
        if(root.left==null)
            return root.value;
        return min(root.left);
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        insertValue(4);
        insertValue(5);
        insertValue(2);
        insertValue(1);
        insertValue(6);
        InorderTraversal(root);
//        greaterSum(root);
//        System.out.println();
//        InorderTraversal(root);
        System.out.println();
        System.out.println(delete(root,4));
        InorderTraversal(root);

    }
}
