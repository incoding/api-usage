package com.javaapi.test.spring.zotherFeature.scheduler.quartz.dynamicSpringAdd;

//
///**
// * 还未整完
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("applicationContext.xml")
//public class ClientDynamicNew implements BeanFactoryAware{
//
//	@Autowired
//	SchedulerFactoryBean SchedulerFactoryBean;
//
//
//	private BeanFactory	beanFactory;
//
//
//	@Test
//	public void getGetTrigger() throws Exception {
////		String cronExpression = "0,5,10,15,20,25,30,35,40,45,50,55 * * * * ?";
//        String jobName = "11";
//        addJob(jobName, "0,5,10,15,20,25,30,35,40,45,50,55 * * * * ?");
//        addJob(jobName, "0,1,2,3,4,6,7,8,9,40,45,50,55 * * * * ?");
////		addJob("0,1,2,3,4,6,7,8,9,40,45,50,55 * * * * ?");
//        try {
//            // 休眠十小时
//            TimeUnit.HOURS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 多个定时任务共享相同实例, 任务中可以使用spring来注入成员变量
//     * @param jobName
//     * @param cronExpression
//     * @throws ParseException
//     * @throws SchedulerException
//     */
//	private void addJob(String jobName, String cronExpression) throws ParseException,
//			SchedulerException {
//		Scheduler scheduler = SchedulerFactoryBean.getScheduler();
//		CronTriggerBean trigger = beanFactory.getBean("doTime", CronTriggerBean.class);
//		trigger.setCronExpression(cronExpression);
//		JobDetail job  =  beanFactory.getBean("jobtask", JobDetail.class);
//		job.setName(jobName);
//		trigger.setName(jobName);
//		scheduler.scheduleJob( job, trigger);
//	}
//
//    private void pauseJob(){
//
//    }
//
//
//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//		 this.beanFactory = beanFactory;
//	}
//
//	@Test
//	public void testGetJob() throws Exception {
//		JobDetail job  =  beanFactory.getBean("jobtask",JobDetail.class);
//		System.err.println(job);
//
//		JobDetail job_tmp  =  (JobDetail) beanFactory.getBean("jobtask");
//		System.err.println(job_tmp);
//
//		System.err.println(job == job_tmp);
//
//
//
//	}
//
//}
