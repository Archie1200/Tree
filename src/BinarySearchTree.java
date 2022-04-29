

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.value=value;
    }
    TreeNode(){

    }
}
public class BinarySearchTree {
    TreeNode root;
    public  TreeNode Insert(TreeNode node,int value){
        TreeNode a= new TreeNode();
        if(node==null){
            a.value=value;
            return a;
        }
        else if(value<node.value){
            node.left=Insert(node.left,value);
            return node;
        }
        else{
            node.right=Insert(node.right,value);
            return node;
        }
    }
    public void insert(int value){
        root=Insert(root,value);
    }
    public int count(TreeNode node){
        if(node==null)
            return 0;
        return count(node.left)+count(node.right)+1;
    }
    public int height(TreeNode node){
        if(node==null)
            return -1;
        return Math.max(height(node.left)+1,height(node.right)+1);
    }
    public void PreOrder(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.value+" ");
        PreOrder(node.left);
        PreOrder(node.right);
    }
    public void PostOrder(TreeNode node){
        if(node==null)
            return;

        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.value+" ");
    }
    public void InOrder(TreeNode node){
        if(node==null)
            return;
        InOrder(node.left);
        System.out.print(node.value+" ");
        InOrder(node.right);
    }
    public int Min(TreeNode node){
        if(node==null) {
            return -1;
        }
        else if(node.left==null)
            return node.value;
        node=node.left;
        return Min(node);
    }
    public int Max(TreeNode node){
        if(node==null) {
            return -1;
        }
        else if(node.right==null)
            return node.value;
        node=node.right;
        return Max(node);
    }
    public int Successor(TreeNode node){
        if(node.left==null)
            return root.value;
        return Successor(node.left);
    }
    public int predecessor(TreeNode node){
        if(node.right==null)
            return root.value;
        return predecessor(root.right);
    }
    public TreeNode delete(TreeNode node,int value){
        if(node==null)
            return null;
        else if(value<node.value){
            node.left=delete(node.left,value);
        }
        else if(value>node.value){
            node.right=delete(node.right,value);
        }
        else{
            if(node.left==null && node.right==null)
                return null;
            else if(node.left==null)
                return node.right;
            else if(node.right==null)
                return node.left;
            else {
                int min = Successor(node.right);
                root.value = min;
                node.right = delete(node.right, min);
            }
        }
        return node;
    }
    public void Delete(int value){
        root=delete(root,value);
    }
}
class A{
    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        obj.insert(20);
        obj.insert(10);
        obj.insert(30);
        obj.insert(5);
        //System.out.println(obj.height(obj.root));
        //System.out.println(obj.Max(obj.root));
        obj.PreOrder(obj.root);
        System.out.println();
       obj.Delete(20);
       obj.PreOrder(obj.root);
    }
}
