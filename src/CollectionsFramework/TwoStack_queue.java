package CollectionsFramework;

import java.util.Stack;

/**
 * @program: java基础算法-数据结构
 * @description: 上锁是为了保证线程安全
 *             两个栈就像两个水桶，水就是元素，
 *             只需将一只桶里面的水倒入另一只桶，新装满水的桶，再倒出去，就形成了一个队列
 * @author: jiangzq
 * @create: 2019-11-27 10:24
 **/
public class TwoStack_queue {
    Object lock = new Object();
    Stack<Integer> input;
    Stack<Integer> output;

    //初始化数据结构
    public TwoStack_queue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    //将元素x推到队列的后面，压入的时候上把锁
    public void push(int x) {
        synchronized (lock) {
            input.push(x);
        }
    }

    private void transform() {
        while (input.size() > 0) {
            output.push(input.pop());
        }
    }

    //从队列前面移除元素并返回该元素，弹出的时候上把锁
    public int pop() {
        if (output.size() == 0) {
            synchronized (lock) {
                transform();
            }
        }
        return output.peek();
    }

    //返回队列是否为空
    public boolean empty() {
        if (input.size() == 0 && output.size() == 0)
            return true;
        else
            return false;
    }
}
