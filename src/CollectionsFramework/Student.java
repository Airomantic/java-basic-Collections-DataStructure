package CollectionsFramework;

/**
 * @program: java基础算法-数据结构
 * @description:
 * @author: jiangzq
 * @create: 2019-11-26 10:52
 **/
public class Student {
    public int number; //设置成公共属性，方便其他类调用该类中的各个属性
    public int grade;
    public String name;

    public Student(int number, String name, int grade) {
        this.number = number;
        this.grade = grade;
        this.name = name;
    }

    //对于TestLinkedList类,需要toString()
    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }
}
