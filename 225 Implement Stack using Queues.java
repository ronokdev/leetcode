package queueUsingStack;


import java.util.LinkedList;

class MyQueue
{
    // declaring two stack- --------------
    LinkedList<Integer> stack_f = new LinkedList<>();
    LinkedList<Integer> stack_s = new LinkedList<>();


    // Doing nothing with the default constructor
    public MyQueue()
    {
    }


    public void push(int x)
    {
        /*
         * when the first & Second stack both are empty
         * that means it's the first element in the Stack
         * in this case we just push the element into the first stack
         * */
        if (stack_f.size() == 0 && stack_s.size() == 0) {
            stack_f.push(x);
        }
        /*
         * this x element is not the first element entering into the stack
         * */
        else {
            /*
             * when the second stack is not empty & there might be some element present in the first stack
             * so we need to pop every element one by one from second stack & push to first stack
             * Then we can push the incoming x element.
             * */
            if (stack_s.size() != 0) {
                while (stack_s.size() != 0) {
                    stack_f.push(stack_s.pop());
                }
                stack_f.push(x);
            }
            /*
             * The second stack is empty & there might be some element present in the first stack.
             * in this case we just push the x element in the first stack.
             * */
            else {
                stack_f.push(x);
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop()
    {
        /*
         * we have nothing to pop if the both stack is empty
         * */
        if (stack_s.size() == 0 && stack_f.size() == 0) return 0;

        /*
         * we will only pop from the second stack
         * for this , we will pop every element one by one from the first stack & push to the second stack
         * After that , we just pop from the Second stack
         * */
        while (stack_f.size() != 0) {
            stack_s.push(stack_f.pop());
        }
        return stack_s.pop();
    }

    /**
     * Get the front element.
     */
    public int peek()
    {
        /*
         * Peek is just like the pop
         * we just peek from the second stack instead of pop
         * */
        if (stack_s.size() == 0 && stack_f.size() == 0) return 0;
        while (stack_f.size() != 0) {
            stack_s.push(stack_f.pop());
        }
        return stack_s.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty()
    {
        /*
         * If both the stack size is ZERO then we are returning empty true.
         * */
        if (stack_s.size() == 0 && stack_f.size() == 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public StringBuilder SecondstackPrint()
    {
        StringBuilder full_stack = new StringBuilder(" ");
        for (int i = 0; i < stack_f.size(); i++) {
            full_stack.append(stack_f.get(i));
            full_stack.append(" :: ");
        }
        return full_stack;
    }

    // second stack printing
    public StringBuilder stackPrint()
    {
        StringBuilder full_stack = new StringBuilder(" ");
        for (int i = 0; i < stack_s.size(); i++) {
            full_stack.append(stack_s.get(i));
            full_stack.append(" :: ");
        }
        return full_stack;
    }
}

public class solutions
{
    public static void main(String[] args)
    {
        MyQueue myQueue = new MyQueue();
        System.out.println("peek → " + myQueue.peek());
        System.out.println("pop → " + myQueue.pop());
        myQueue.push(5);
        System.out.println("pop → " + myQueue.pop());
        myQueue.push(6);
        myQueue.push(21);
        System.out.println("peek → " + myQueue.peek());
        System.out.println("first stack → " + myQueue.stackPrint());
        System.out.println("second stack  → " + myQueue.SecondstackPrint());
        System.out.println("pop → " + myQueue.pop());
        myQueue.push(9);
        System.out.println("peek → " + myQueue.peek());
        System.out.println("pop → " + myQueue.pop());
        System.out.println("pop → " + myQueue.pop());
        System.out.println("Empty → " + myQueue.empty());
        System.out.println("pop → " + myQueue.pop());
        System.out.println("Empty → " + myQueue.empty());
        System.out.println("first stack → " + myQueue.stackPrint());
        System.out.println("second stack → " + myQueue.SecondstackPrint());
    }
}


