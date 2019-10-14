package minstack;

import java.util.*;

class MinStack
{
    // Creating Two Stack
    LinkedList<Integer> minStack = new LinkedList<Integer>();
    LinkedList<Integer> stack = new LinkedList<Integer>();

    public void push(int x)
    {
        stack.push(x);
        /*
        * Checking for secondary stack size
        * If the first element in that stack is grater than x then we push x in the minStack  
        * */
        if (minStack.size() != 0) {
            int min = minStack.peek();
            if (min >= x) {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }

    }
    
    
    public int pop()
    {
        int popping_item = stack.pop();
        /*
        * when popping if the first element matches in two stacks , then we pop them from both stack.
        * */
        if (minStack.size() != 0) {
            if (popping_item == minStack.peek()) {
                minStack.pop();
            }
        }
        return popping_item;
    }
    
    
    public int top()
    {
        return stack.peek();
    }
    
    public int getMin()
    {
        return minStack.peek();
    }
    
    public StringBuilder stackPrint()
    {
        StringBuilder full_stack = new StringBuilder(" ");
        for (int i = 0; i < stack.size(); i++) {
            full_stack.append(stack.get(i));
            full_stack.append(" :: ");
        }
        return full_stack;
    }

    public StringBuilder MinstackPrint()
    {
        StringBuilder full_min_stack = new StringBuilder(" ");
        for (int i = 0; i < minStack.size(); i++) {
            full_min_stack.append(minStack.get(i));
            full_min_stack.append(" :: ");
        }
        return full_min_stack;
    }
}

public class minstacksolution
{
    public static void main(String[] args)
    {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println("Main Stack → "+minStack.stackPrint());
        System.out.println("MINIMUM Stack → "+minStack.MinstackPrint());
        System.out.println(minStack.getMin());
    }
}
