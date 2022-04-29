class Node2{
    Node2 left;
    Node2 right;
    int value;
    Node2(int value){
        this.value=value;
    }
    Node2(){

    }
}
public class tocheckBST {
    Node2 root;
    public static boolean check(Node2 root){
        if(root==null)
            return true;
        else if(root.left!=null && root.left.value>root.value){
            return false;
        }
        else if(root.right!= null && root.right.value<root.value){
            return false;
        }
        else if(!check(root.left) || !check(root.right))
            return false;
        return true;
    }
    public static Node2 BSTInsertion(Node2 root,Node2 node){
        Node2 a = new Node2();
        if(root==null){
            a.value=node.value;
            return a;
        }
        else if(node.value<root.value){
            root.left=BSTInsertion(root.left,node);
            return root;
        }
        else{
            root.right=BSTInsertion(root.right,node);
            return root;
        }
    }

    public static void preOrder(Node2 root){
        if(root==null)
            return;
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node2 n1 = new Node2(10);
        Node2 n2 = new Node2(5);
        Node2 n3 = new Node2(20);
        Node2 n4 = new Node2(2);
        Node2 n5 = new Node2(6);
        /*BSTInsertion(null,n1);
        BSTInsertion(n1,n2);
        BSTInsertion(n1,n3);
        BSTInsertion(n1,n4);
        BSTInsertion(n1,n5);*/
        tocheckBST obj = new tocheckBST();
        obj.root=n1;
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        preOrder(n1);
        System.out.println();
        System.out.println(check(n1));
    }
}
