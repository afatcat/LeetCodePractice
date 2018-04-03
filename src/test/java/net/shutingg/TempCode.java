package net.shutingg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TempCode {
    /*
    Stack iterator in wrong order - bottom to top
     */
    @Test
    public void testStack() {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack2.addAll(stack1);
        list.addAll(stack1);
        System.out.println("stack 1: ");
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop() + " ");
        }
        System.out.println();
        System.out.println("stack 2: ");
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
        System.out.println();
        System.out.println("list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
