package com.javaapi.test.spring.zotherFeature.scheduler.quartz.dynamicSpringAdd;

///**
// * 还未整完
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("applicationContext.xml")
//public class ClientDynamic implements BeanFactoryAware{
//
//	@Autowired
//	SchedulerFactoryBean SchedulerFactoryBean;
//
//
//	private BeanFactory	beanFactory;
//
//
//
//
//	@Test
//	public void testDynamic() throws Exception {
//        addJob();
//        addJob2();
////        getJobList();
//		try {
//			// 休眠十小时
//			TimeUnit.HOURS.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//
//
//	private void getJobList() throws SchedulerException {
//		Scheduler scheduler = SchedulerFactoryBean.getScheduler();
//		String[] jobGroupNames = scheduler.getJobGroupNames();
//		for (String group : jobGroupNames) {
//			System.out.println(group);
//			String[] jobNames = scheduler.getJobNames(group);
//			for (String job : jobNames) {
//				System.out.println(job);
//				JobDetail jobDetail = scheduler.getJobDetail(job, group);
//				System.out.println(jobDetail);
//			}
//		}
//
//	}
//
////	@SuppressWarnings("unused")
////	private <T> boolean  addJob(Class<T> clazz,String method,String express) {
////		Scheduler scheduler = SchedulerFactoryBean.getScheduler();
////		CronTrigger trigger = new CronTrigger("cronTrigger_"+clazz.toString()+"_"+method, "triggerGroup");// 触发器名,触发器组
////		try {
////			trigger.setCronExpression(express);
////		} catch (ParseException e) {
////			e.printStackTrace();
////			return false;
////		}
////		return true;
////	}
//
//
//    /**
//     * 这样只能将成员变量实例  通过    jobDataMap 传入,不能通过spring注入
//     * @throws ParseException
//     * @throws SchedulerException
//     */
//	private void addJob() throws ParseException, SchedulerException {
//		Scheduler scheduler = SchedulerFactoryBean.getScheduler();
//		CronTrigger trigger = new CronTrigger("cronTrigger", "triggerGroup");// 触发器名,触发器组
//		String cronExp = "10,15,20,25,30,35,40,45,50,55 * * * * ?";
//		trigger.setCronExpression(cronExp);// 触发器时间设定
//		JobDetail jobDetail = new JobDetail();
//		jobDetail.setJobClass(SelfJob.class);
//		jobDetail.setName("tmp");
//		//--
//		SelfJob bean = beanFactory.getBean("selfJob", SelfJob.class);
//		//----
//		JobDataMap jobDataMap = new JobDataMap();
//		jobDataMap.put("selfJob", bean);
//        jobDataMap.put("var", 1);
//
//		jobDetail.setJobDataMap(jobDataMap);
//		//----
//		scheduler.scheduleJob(jobDetail, trigger);
//		// 启动
//		if (!scheduler.isShutdown()) {
//			scheduler.start();
//		}
//	}
//    /**1 没跑一次产生一个SelfJob
//     * 2 这样只能将成员变量实例  通过    jobDataMap 传入,不能通过spring注入
//     * @throws ParseException
//     * @throws SchedulerException
//     */
//	private void addJob2() throws ParseException, SchedulerException {
//		Scheduler scheduler = SchedulerFactoryBean.getScheduler();
//		CronTrigger trigger = new CronTrigger("cronTriggerTmp", "triggerGroup");// 触发器名,触发器组
//		String cronExp = "10,15,20,25,30,35,40,45,50,55 * * * * ?";
//		trigger.setCronExpression(cronExp);// 触发器时间设定
//		JobDetail jobDetail = new JobDetail();
//		jobDetail.setJobClass(SelfJob.class);
//		jobDetail.setName("tmp2");
//		//--
//		SelfJob bean = beanFactory.getBean("selfJob", SelfJob.class);
//		//----
//		JobDataMap jobDataMap = new JobDataMap();
//		jobDataMap.put("selfJob", bean);
//        jobDataMap.put("var", 2);
//		jobDetail.setJobDataMap(jobDataMap);
//		//----
//		scheduler.scheduleJob(jobDetail, trigger);
//		// 启动
//		if (!scheduler.isShutdown()) {
//			scheduler.start();
//		}
//
//	}
//
//
//	@Test
//	public void testGet() throws Exception {
//		Object bean = beanFactory.getBean("&jobtask");
//		System.out.println(bean);
//		Object bean2 = beanFactory.getBean("jobtask");
//		System.out.println(bean2);
//		try {
//			// 休眠十小时
//			TimeUnit.HOURS.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void getGetTrigger() throws Exception {
//		Scheduler scheduler = SchedulerFactoryBean.getScheduler();
//		CronTriggerBean bean = beanFactory.getBean("doTime", CronTriggerBean.class);
//		bean.setCronExpression("0,5,10,15,20,25,30,35,40,45,50,55 * * * * ?");
//		MethodInvokingJobDetailFactoryBean methodInvoker = beanFactory.getBean("&jobtask", MethodInvokingJobDetailFactoryBean.class);
//		JobDetail jobDetail = new JobDetail(bean.getJobDetail().getName(), bean.getJobDetail().getGroup(),  MethodInvokingJob.class);
//		jobDetail.setVolatility(true);
//		jobDetail.setDurability(true);
//		jobDetail.getJobDataMap().put("methodInvoker", methodInvoker);
//		scheduler.scheduleJob(jobDetail, bean);
//		try {
//			// 休眠十小时
//			TimeUnit.HOURS.sleep(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//		 this.beanFactory = beanFactory;
//	}
//}
