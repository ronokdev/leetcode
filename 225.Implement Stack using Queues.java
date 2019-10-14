package stackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack
{
    /**
     * Initialize your data structure here.
     */
    Queue<Integer> first_q = new LinkedList<>();

    public MyStack()
    {
    }


    /**
     * Push element x onto stack.
     */
    public void push(int x)
    {
        first_q.add(x);
        int queue_size = first_q.size();
        
        //Removing all the old item which came before 'x' & adding them after 'x'
        while (queue_size > 1) {
            int removed_element = first_q.remove();
            first_q.add(removed_element);
            queue_size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop()
    {
        return first_q.remove();
    }

    /**
     * Get the top element.
     */
    public int top()
    {
        return first_q.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty()
    {
        if (first_q.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Queue<Integer> print_q()
    {
        return first_q;
    }
}

public class solutions
{
    public static void main(String[] args)
    {
        MyStack myStack = new MyStack();
        myStack.push(5);
        myStack.push(20);
        myStack.push(19);
        myStack.push(7);
        System.out.println(myStack.print_q());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.print_q());
    }
}
