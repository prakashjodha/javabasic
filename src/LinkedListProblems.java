public class LinkedListProblems {

    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);


        a.next=b;b.next=c; c.next=d;d.next=e;
        e.next=f;f.next=g;
        g.next=null;
       // System.out.println(isListCircular(a));
      //  kThToLastUsingRunnner(a,2);
        Index index=new Index();
        Node kNode=kThToLastUsingBackTrack(a,3,index);
        System.out.println(kNode.data);
    }

    static Node kThToLastUsingBackTrack(Node head, int k,Index index){
        if(head==null)return null;
        Node newNode=kThToLastUsingBackTrack(head.next,k,index);
        index.index+=1;
        if(index.index==k)
            return head;
        return newNode;
    }

    static void kThToLastUsingRunnner(Node head, int k){
        Node slow=head;
        Node fast=head;
        for(int i=0;i<=k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        System.out.println(String.format("%d to the last is %d",k,slow.data));

    }

    static void deleteMiddle(){

    }

    static boolean isListCircular(Node node){
        if(node==null || node.next==null)return false;
        Node slowNode=node;
        Node fastNode=node;
        while(fastNode!=null && fastNode.next!=null){
            System.out.println(slowNode.data +" - "+ fastNode.data);
            slowNode=slowNode.next;
            fastNode=fastNode.next.next;
            if(slowNode==fastNode)return true;
        }
        slowNode=node;
        while(slowNode!=fastNode){
            slowNode=slowNode.next;
        }
        System.out.println(slowNode.data +" - "+ fastNode.data);
        return false;
    }
}


class Index{
    int index;
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}
