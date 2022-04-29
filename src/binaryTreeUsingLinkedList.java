class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value=value;
    }
    Node(){

    }
}
public class binaryTreeUsingLinkedList {
    Node root;
    public Node Insert(Node root,int value){
        Node a = new Node();
        if(root==null) {
            a.value = value;
            return a;
        }
            root.left = Insert(root.left, value);
            root.right = Insert(root.right, value);
            return root;
    }
    public void insert(int value){
        root=Insert(root,value);
    }
    public void preOrderTraversal(Node root){
        if(root==null)
            return;
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void postOrderTraversal(Node root){
        if(root==null)
            return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }
}
class Test{
    public static void main(String[] args) {
        binaryTreeUsingLinkedList obj = new binaryTreeUsingLinkedList();
        for(int i=1;i<=6;i++){
            obj.insert(i);
        }
        obj.preOrderTraversal(obj.root);
        System.out.println();
        obj.postOrderTraversal(obj.root);
    }
}

