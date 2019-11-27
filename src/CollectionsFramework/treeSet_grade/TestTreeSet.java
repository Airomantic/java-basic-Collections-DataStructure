package CollectionsFramework.treeSet_grade;

import CollectionsFramework.Student;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @program: java基础算法-数据结构
 * @description:
 *          result =
 *             ...
 *             学号：2016080063 姓名：同学63  成绩：68
 *             学号：2016080077 姓名：同学77  成绩：68
 *             学号：2016080019 姓名：同学19  成绩：69
 *             学号：2016080066 姓名：同学66  成绩：69
 *             学号：2016080028 姓名：同学28  成绩：71
 *             学号：2016080029 姓名：同学29  成绩：71
 *             学号：2016080052 姓名：同学52  成绩：71
 *             学号：2016080061 姓名：同学61  成绩：72
 *             ...
 * @author: jiangzq
 * @create: 2019-11-26 10:48
 **/
public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Student> treeSet=new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Student s_1 = o1;
                Student s_2 = o2;
                if (s_1.grade > s_2.grade) {
                    return 1;
                }
                if (s_1.grade < s_2.grade) {
                    return -1;
                }
                if (s_1.grade == s_2.grade) {
                    return new Integer(s_1.number).compareTo(new Integer(s_2.number));
                }
                return 0;
            }
        });

        //添加元素进去
        for (int i = 2016080001, j = 1; i <= 2016080099; i++,j++) {
            treeSet.add(new Student(i, "同学" + j, (int) (40 * Math.random() + 60)));
            //迭代循环取出
            Iterator<Student> iterator = treeSet.iterator();
            while (iterator.hasNext()) {
                Student o1 = iterator.next();
                System.out.println("学号："+o1.number+" "+"姓名："+o1.name+" "+" "+"成绩："+o1.grade);
            }
        }
    }
}
