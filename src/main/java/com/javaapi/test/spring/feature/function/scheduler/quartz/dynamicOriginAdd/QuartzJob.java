package com.javaapi.test.spring.feature.function.scheduler.quartz.dynamicOriginAdd;

//
///**
// * 只要线程够就不会影响下次任务执行.如果所有任务都在执行中,则会等到空出线程再执行任务
// *
// * 另外可以设置quartz是否并发执行
// */
//public class QuartzJob implements Job {
//
//    @Override
//    public void execute(JobExecutionContext context)
//            throws JobExecutionException {
//        System.out.println("nihao="+System.currentTimeMillis());
////        SelfJob object = (SelfJob) context.getMergedJobDataMap().get("selfJob");
//        System.out.println("SelfJob回调SelfJob==>"+this);
////		extracted();
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}