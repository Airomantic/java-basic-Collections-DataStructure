package CollectionsFramework.list;

import CollectionsFramework.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @program: java基础算法-数据结构
 * @description:
 *            未在Student类里面添加toString()的运行结果：
 *                                         ...
 *                                        CollectionsFramework.Student@4f023edb
 *                                        CollectionsFramework.Student@3a71f4dd
 *                                        CollectionsFramework.Student@7adf9f5f
 *                                        CollectionsFramework.Student@85ede7b
 *                                        CollectionsFramework.Student@5674cd4d
 *                                        ...
 *                           在Student()类中加上重写toString().result =
 *                                        ...
 *                                        Student{number=2016080083, grade=91, name='同学92'}
 *                                        Student{number=2016080002, grade=92, name='同学11'}
 *                                        Student{number=2016080029, grade=92, name='同学38'}
 *                                        Student{number=2016080092, grade=92, name='同学101'}
 *                                        ...
 * @author: jiangzq
 * @create: 2019-11-26 11:43
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Student> linkedList = new LinkedList<>();
        for (int i = 2016080001, j = 10; i < 2016080098; i++, j++) {
            linkedList.add(new Student(i, "同学" + j,(int) (40 * Math.random() + 60)));//与有参构造对应好
        }
        //对链表排序，内部创建一个比较器
        Collections.sort(linkedList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.grade > o2.grade) {
                    return 1;
                }
                if (o1.grade < o2.grade) {
                    return -1;
                }
                if (o1.grade == o2.grade) {
                    return new Integer(o1.number).compareTo(new Integer(o2.number));
                }
                return 0;
            }
        });
        //输出链表
        for (Student student : linkedList) {
            System.out.println(student);
        }
    }
}
