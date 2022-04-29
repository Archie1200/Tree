import java.util.ArrayList;
import java.util.LinkedList;

public class greaterValue {
    BinaryNode root;
    public static BinaryNode insert(BinaryNode root,BinaryNode node){
        BinaryNode a = new BinaryNode();
        if(root==null){
            a.value=node.value;
            return a;
        }
        else if(node.value< root.value){
            root.left=insert(root.left,node);
            return root;
        }
        else{
            root.right=insert(root.right,node);
            return root;
        }
    }
    public void update(BinaryNode root,BinaryNode node,BinaryNode node2){
        if(root==null)
            return;
        update(root.left, node,node2);
        int s=greaterThan(node,0,root.value);
        //node=node2;
        root.value=s;
       System.out.print(root.value+" ");
       update(root.right, node,node2);
    }
    public int greaterThan(BinaryNode root,int sum,int a){
        if(root.value>a){
            sum+=root.value;
            //System.out.println(root.value);
            // return sum;
        }
        if(root.left!=null) {
            greaterThan(root.left, sum, a);
        }
        if(root.right!=null){
            greaterThan(root.right,sum,a);
        }
        return sum;
    }
    public  void preOrder(BinaryNode root){
        if(root==null)
            return;
        preOrder(root.left);
        System.out.print(root.value+" ");
        preOrder(root.right);
    }
    public static void main(String[] args) {
        int arr[] = {30, 20, 50, 25, 35, 40, 10};
        greaterValue obj = new greaterValue();
        BinaryNode ap = new BinaryNode(arr[0]);
        insert(null,ap) ;
       for (int i = 1; i < arr.length; i++) {
            insert(ap, new BinaryNode((arr[i])));
        }
        obj.preOrder(ap);
        System.out.println();
        obj.update(ap, ap,ap);

    }

}
