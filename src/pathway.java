import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

class BinaryNode{
    int value;
    BinaryNode left;
    BinaryNode right;
    BinaryNode(){

    }
    BinaryNode(int value){

        this.value=value;
    }
}
public class pathway {
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
    public static LinkedList<Integer> Path(BinaryNode root,int value){
        if(root==null){
            return null;
        }
        else if(root.value==value){
            LinkedList<Integer> obj = new LinkedList<>();
            obj.add(root.value);
            return obj;
        }
        else if(value<root.value){
            LinkedList<Integer> left=Path(root.left,value);
            if(left!=null){
                left.add(root.value);
                return left;
            }
        }
        else{
            LinkedList<Integer> right= Path(root.right,value);
            if(right!=null){
                right.add(root.value);
                return right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryNode a1 = new BinaryNode(10);
        BinaryNode a2 = new BinaryNode(20);
        BinaryNode a3 = new BinaryNode(30);
        BinaryNode a4 = new BinaryNode(6);
        BinaryNode a5 = new BinaryNode(5);
        BinaryNode a6 = new BinaryNode(25);
        insert(null,a1);
        insert(a1,a2);
        insert(a1,a3);
        insert(a1,a4);
        insert(a1,a5);
        insert(a1,a6);
        LinkedList res=Path(a1,25);

        if(res==null)
            System.out.println("Value Not found");
        else{
            int a=res.size();
            int c=0;
            Collections.reverse(res);
            Iterator p = res.iterator();
            while(p.hasNext()){
                System.out.print(p.next());
                if(c!=a-1){
                    System.out.print("->");
                    c++;
                }
            }
        }
    }
}
