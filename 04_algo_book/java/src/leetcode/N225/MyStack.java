package leetcode.N225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> standardQueue;
    Queue<Integer> reversedQueue;

    public MyStack() {
        standardQueue = new LinkedList<>();
        reversedQueue = new LinkedList<>();
    }

    public void push(int x) {
        // 1 2 3 을 3 2 1 로 바꾸려면 전체 length-1 만큼 뺐다가 넣으면 됨

        /*
            1 2
            2 1

            1 2 3
            2 1 3 -> 3 2 1

         */

        standardQueue.add(x);
        reversedQueue.add(x);

        for (int i = 0; i < reversedQueue.size()-1; i++) {
            Integer poll = reversedQueue.poll();
            reversedQueue.add(poll);
        }
    }

    public int pop() {

        for (int i = 0; i < standardQueue.size()-1; i++) {
            Integer poll = standardQueue.poll();
            standardQueue.add(poll);
        }
        standardQueue.poll();

        return reversedQueue.poll();
    }

    public int top() {
        return reversedQueue.peek();
    }

    public boolean empty() {
        return standardQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        boolean empty = myStack.empty();
        System.out.println("empty = " + empty);
        System.out.println();

    }

}
