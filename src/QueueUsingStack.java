import java.util.Stack;

public class QueueUsingStack {
}

class QueueStack{
    Stack<Integer> stack1;
    Integer queueHead=Integer.MIN_VALUE;



    QueueStack(){
        stack1=new Stack<>();

    }

    public void push(Integer val){
        if(stack1.isEmpty()){
            queueHead=  val;
        }
        stack1.push(val);
    }

    public int pop(){
        Stack<Integer> stack2=new Stack<>();
        while(! stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
       int value= stack2.pop();
        // if it is the last vlaue
        if(stack2.isEmpty()){
            queueHead=0;
        }else{

            queueHead=  stack2.peek();
            while( !stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }

        return value;
    }

    public int poll(){

        return queueHead;
    }

}


// Queue using Stack
// FIFO LIFO
/**
 * Stack.push()
 * 3
 * 2
 * 1
 *
 *
 * 1
 * 2
 * 3
 *
 * 2
 * 1
 *
 * Queue.push() ->
 */