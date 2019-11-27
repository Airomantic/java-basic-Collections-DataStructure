package CollectionsFramework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: java基础算法-数据结构
 * @description: 两个队列实现栈
 * @author: jiangzq
 * @create: 2019-11-27 10:14
 **/
public class TwoQueue_stack { //这方法方便两个队列构造的栈来进行调用
    private Queue<Integer> a;//输入队列
    private Queue<Integer> b;//输出队列

    public TwoQueue_stack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while (!b.isEmpty()) {
            a.offer(b.poll());
            // 交换a和b,使得a队列没有在push()的时候始终为空队列
            Queue temp = a;
            a = b;
            b = temp;
        }
    }

    public int pop() {
        return b.poll();
    }

    public int top() {
        return b.peek();
    }

    public boolean empty() {
        return b.isEmpty();
    }
}
