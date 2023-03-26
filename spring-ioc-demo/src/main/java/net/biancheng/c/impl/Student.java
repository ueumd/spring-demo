package net.biancheng.c.impl;

public class Student {
    private int id;
    private String name;
    private Grade grade;


    public Student() {
    }

    public Student(int id, String name, Grade grade) {
        System.out.println("正在执行 Student 的有参构造方法，参数分别为：id=" + id + ",name=" + name + ",grade=" + grade + "\n");
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setId(int id) {
        System.out.println("正在执行 Student 类的 setId() 方法……");
        this.id = id;
    }

    public void setName(String name) {
        System.out.println("正在执行 Student 类的 setName() 方法…… ");
        this.name = name;
    }

    public void setGrade(Grade grade) {
        System.out.println("正在执行 Student 类的 setGrade() 方法…… ");;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}