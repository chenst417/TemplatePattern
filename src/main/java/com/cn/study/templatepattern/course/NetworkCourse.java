package com.cn.study.templatepattern.course;

public abstract class NetworkCourse {

    protected final void createCourse(){
        // 1、发布预习资料
        this.postPreResource();

        //2、制作PPT
        this.createPPT();

        //3、在线直播
        this.createVideo();

        //4、提交课件、课堂笔记
        this.postNote();

        //5、提交源代码
        this.postSource();

        //6、布置作业，有些课是没有作业的，有些课是有作业的
            //如果有作业，就检查作业，没有就完成啦。
        if(needHomeWork()){
            this.checkHomeWork();
        }
    }

    final void postPreResource(){
        System.out.println("发布预习资料。");
    }

    final void createPPT(){
        System.out.println("创建备课PPT。");
    }

    final void createVideo(){
        System.out.println("直播授课。");
    }

    final  void postNote(){
        System.out.println("提交课件和笔记。");
    }

    final void postSource(){
        System.out.println("提交源代码。");
    }

    // 钩子方法
    protected boolean needHomeWork(){
        return false;
    }

    abstract void checkHomeWork();

}
