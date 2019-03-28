package com.cn.study.templatepattern.course;

public class NetworkCourseTest {

    public static void main(String[] args) {
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();

        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.err.println("=====================================");

        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();


    }
}
