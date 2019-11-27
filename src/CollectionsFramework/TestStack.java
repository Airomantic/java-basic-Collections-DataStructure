package CollectionsFramework;

import java.util.Stack;

/**
 * @program: java基础算法-数据结构
 * @description:
 *        result =
 *             0123456789
 *             ---------2---------
 *             9876543210
 * @author: jiangzq
 * @create: 2019-11-26 12:23
 **/
public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        //集合遍历方式
        for (Integer x: stack) {
            System.out.print(x);
        }
        System.out.println("\n---------2---------");
        //错误遍历
        /*for (Integer x : stack) {
            System.out.println(stack.pop());
        }*/
        //while(s.peek()!=null){} 是不健壮的判断方式，容易抛出异常
        //正确栈弹出遍历
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }

    }
}
