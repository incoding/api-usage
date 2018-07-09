package com.javaapi.test.testUtil.opensource.reactive.rxjava.operations.transform;

import org.junit.Test;
import org.testng.collections.Lists;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://blog.csdn.net/johnny901114/article/details/51532776
 * 看不懂,先记录下
 * https://www.jianshu.com/p/52cd2d514528   这个解释清楚了
 *
 * 更多操作符
 * https://www.zhihu.com/question/32209660
 */
public class ClientFlatMap {

    @Test
    public void testMap() {
        List<Student> students = getStudents();
        Action1<List<Course>> action1 = new Action1<List<Course>>() {
            @Override
            public void call(List<Course> courses) {
                //遍历courses，输出cuouses的name
                for (int i = 0; i < courses.size(); i++){
                    System.out.println("courses.get(i).getName() = " + courses.get(i).getName());
                }
            }
        };
        Observable.from(students)
                .map(new Func1<Student, List<Course>>() {
                    @Override
                    public List<Course> call(Student student) {
                        //返回coursesList
                        return student.getCoursesList();
                    }
                })
                .subscribe(action1);
    }

    @Test
    public void testFlatMap() throws Exception {
        List<Student> students = getStudents();
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCoursesList());
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        System.out.println("course = " + course.getName());
                    }
                });

    }

    private List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setName("张三");
        student.setCoursesList(Lists.newArrayList(new Course("数学","1"),new Course("英语","2")));

        Student student2 = new Student();
        student2.setName("张三");
        student2.setCoursesList(Lists.newArrayList(new Course("语文","3"),new Course("英语","2")));
        students.add(student);
        students.add(student2);
        return students;
    }


    /**
     * 学生类
     */
    class Student {
        //姓名
        private String name;
        //所修的课程
        private List<Course> coursesList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Course> getCoursesList() {
            return coursesList;
        }

        public void setCoursesList(List<Course> coursesList) {
            this.coursesList = coursesList;
        }

        public Student() {
        }

        public Student(String name, List<Course> coursesList) {
            this.name = name;
            this.coursesList = coursesList;
        }
    }

    /**
     * 课程类
     */
    class Course {
        //课程名
        private String name;
        private String id;

        public Course() {
        }

        public Course(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
