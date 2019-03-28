package com.cn.study.templatepattern.course;

public class BigDataCourse extends NetworkCourse {

     private boolean needHomeWorkFlag = false;

     public BigDataCourse(boolean needHomeWorkFlag){
         this.needHomeWorkFlag = needHomeWorkFlag;
     }

    @Override
    void checkHomeWork() {
        System.out.println("检查大数据的课后作业。");
    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeWorkFlag;
    }
}
