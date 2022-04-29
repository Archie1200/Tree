package TREES;
class Node{
    int value;
    Node left;
    Node right;
    int height;
    int balance;
    public Node(int value){
        this.value=value;
    }
    Node(){

    }
}
public class avlTree {
    static Node root1;
    public static Node rightRotation(Node root){
        Node node =root.left;
        Node a=node.right;
        node.right=root;
        root.left=a;
        updateHeightAndBlance(root);
        updateHeightAndBlance(node);
        return node;
    }
    public static Node leftRotation(Node root){
        Node node =root.right;
        Node a=node.left;
        node.left=root;
        root.right=a;
        updateHeightAndBlance(root);
        updateHeightAndBlance(node);
        return node;
    }
    public static Node Insert(Node root,int value){
        Node a = new Node();
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
    public  static  Node insertValue(int value){
        root1=Insert(root1,value);
        return root1;
    }
    public  static Node getRotation(Node root){
        updateHeightAndBlance(root);
        if(root.balance==2) {
            if (root.left.balance == 1)
                return rightRotation(root);
            else{
                root.left=leftRotation(root.left);
                return rightRotation(root);
            }
        }
        else if(root.balance==-2){
            if(root.right.balance==-1)
                return leftRotation(root);
            else{
                root.right=rightRotation(root.right);
                return leftRotation(root);
            }
        }
        return root;
    }
    public static void updateHeightAndBlance(Node root){
        int lh=-1;
        int rh=-1;
        if(root.left!=null)
            lh=root.left.height;
        if(root.right!=null)
            rh=root.right.height;
        root.balance=lh-rh;
        root.height=Math.max(lh,rh)+1;
    }
//    public static void display(Node root){
//        if(root==null)
//            return;
//        String str="";
//        str+=root.left!=null? root.left.value+" ":".";
//        str+="<-"+ root.value+"->";
//        str+= root.right!=null?root.right.value+" ":" ";
//        System.out.println(str);
//        display(root.left);
//        display(root.right);
//    }
    public static void InOrder(Node root){
        if(root==null)
            return;
        InOrder(root.left);
        System.out.print(root.value+" ");
        InOrder(root.right);
    }
    public static void main(String[] args) {
        Node a = new Node();
        insertValue(30);
        insertValue(20);
        insertValue(10);
        insertValue(25);
        insertValue(11);
        insertValue(5);
        InOrder(root1);

    }
}
