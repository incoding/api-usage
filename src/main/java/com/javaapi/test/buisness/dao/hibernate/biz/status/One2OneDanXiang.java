package com.javaapi.test.buisness.dao.hibernate.biz.status;

/**
 * http://www.cnblogs.com/xiaoluo501395377/p/3380270.html   (好)
 * ①.对于刚创建的一个对象，如果session中和数据库中都不存在该对象，那么该对象就是瞬时对象(Transient)
 *
 *  ③.离线对象就是，数据库存在该对象，但是该对象又没有被session所托管


 ②.瞬时对象调用save方法，或者离线对象调用update方法可以使该对象变成持久化对象，如果对象是持久化对象时，那么对该对象的任何修改，都会在提交事务时才会与之进行比较，如果不同，则发送一条update语句，否则就不会发送语句

 =====================
 *
 * <p>
 * <p>
 * CREATE TABLE `bill` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `billname` varchar(45) DEFAULT NULL,
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 * <p>
 * CREATE TABLE `billdetail` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `billid` int(11) DEFAULT NULL,
 * `create_user` varchar(45) DEFAULT NULL,
 * PRIMARY KEY (`id`),
 * KEY `billid_idx` (`billid`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
 * <p>
 * 当设为true的时候，Hibernate在运行期动态产生sql语句，对于insert来说，只插入那些不是null的属性，这样就可以支持数据库字段的default属性；
 * </br>
 * 对于update来说，只更新那些修改过的属性。
 * <p>
 * 4.3.1 使用http://blog.csdn.net/shijiebei2009/article/details/42643949
 */
public class One2OneDanXiang {
//
//    private SessionFactory sf;
//
////	@Before
////	public void testConfigure() throws Exception {
////		Configuration cfg=new Configuration();
////		// 绝对路径只能这么写
////		cfg.configure(new File(this.getClass().getResource("").getPath() + "hibernate.cfg.xml"));
////		sf = cfg.buildSessionFactory();
////	}
//
//    @Before
//    public void test() {
//        Configuration configuration = new Configuration().configure(new File(this.getClass().getResource("").getPath() + "hibernate.cfg.xml"));
//        // Hibernate3.x的写法，已淘汰
////        SessionFactory buildSessionFactory = configuration.buildSessionFactory();
//        // Hibernate4.x之后的新方法
//        // 这种写法已过时，被标准的StandardServiceRegistry所取代
////        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
////                .buildServiceRegistry();
//        // 4.3.7所推荐使用的方法
//
//
//        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
//        EventListenerRegistryImpl eventListenerRegistry = new EventListenerRegistryImpl();
//        eventListenerRegistry.appendListeners(EventType.SAVE_UPDATE, SelfSaveOrUpdateListener.class);
//        standardServiceRegistryBuilder.addService(EventListenerRegistry.class, new EventListenerRegistryImpl());
//        StandardServiceRegistry registry = standardServiceRegistryBuilder.applySettings(configuration.getProperties())
//                .build();
////        EventListenerRegistry service = registry.getService(EventListenerRegistry.class);
////        service.appendListeners(EventType.SAVE_UPDATE, SelfSaveOrUpdateListener.class);
//        // 可以把configuration.getProperties()打印出来看看，发现就是一些系统的变量键值对
//        Properties properties = configuration.getProperties();
//        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
//        for (Map.Entry<Object, Object> entry : entrySet) {
//            System.out.println(entry);
//        }
//        // 获取sessionFactory对象
//        sf = configuration.buildSessionFactory(registry);
//    }
//    // ==============================================
//    //瞬时对象得insert是立即生效的,也就是执行save后立刻插入,不用等到事物提交
//    // 瞬时对象转持久化对象 ,对瞬时对象save,saveOrUpdate
//    @Test
//    public void TestPersistent02() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setBillname("new save");
//        openSession.save(load);
////        openSession.saveOrUpdate(load);
//
//        System.out.println("nihaoooooo");
//        load.setBillname("new  update");
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//
//    /**
//     *离线转持久  update,saveOrUpdate   , lock.
//     * 转成持久化后,提交前与持久化对象进行比较,有不同就更新(  属性改变在持久化对象前或后都没关系,只要改变了,就在事物提交前进行更新)
//     * @throws Exception
//     */
//    @Test
//    public void testLixianToPersist_start() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setId(4);
//        load.setBillname("1.1");
//        openSession.update(load);
////        openSession.saveOrUpdate(load);
////        openSession.lock(load, LockMode.NONE);
////        load.setBillname("3");
//        beginTransaction.commit();
//        openSession.close();
//    }
//    //-----
//    // 持久转离线
//    //再看这个例子，当我们load出user对象时，此时user是持久化的对象，在session缓存中存在该对象，此时我们在对user进行修改后，然后调用session.clear()方法，这个时候就会将session的缓存对象清空，那么session中就没有了user这个对象，这个时候在提交事务的时候，发现已经session中已经没有该对象了，所以就不会进行任何操作，因此这里只会发送一条select语句
//    @Test
//    public void testPersistToLiXian() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = (Bill) openSession.load(Bill.class, 4);
//        load.setBillname("2");
////        openSession.clear(); //clear(清除所有对象),clear之后变为离线对象,修改不会生效
////        openSession.evict(load); //evict(只清除该对象session中实例,不会影响数据库)evict之后变为离线对象,修改不会生效
//        openSession.close();  // session 都关了,清除session内所有对象, close  之后变为离线对象,修改不会生效
//        load.setBillname("7");
//        System.out.println("nihaoooooo");
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//
//
//    /// ------------------
//
//
//    // 离线对象转瞬时对象   ,delete
//    //接着我们来看这个例子，这里在调用了session.delete()方法以后，此时后u就会变成一个瞬时对象，因为此时数据库中已经不存在该对象了，既然u已经是一个瞬时对象了，那么对u再进行各种修改操作的话，hibernate也不会发送任何的修改语句，因此这里只会 有一条 delete的语句发生
//    // delete 不在数据库中存在的id,会报错
//    @Test
//    public void testLiXianToShunShi() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setId(9);
//        load.setBillname("1.2");
//        openSession.delete(load);
//        load.setBillname("66");
//        beginTransaction.commit();
//        openSession.close();
//    }
//    // 持久化转瞬时对象  delete
//    @Test
//    public void testPersistToShunShi() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = (Bill) openSession.load(Bill.class, 8);
//        load.setBillname("1.2");
//        openSession.delete(load);
//        load.setBillname("66");
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//
//
//
//
//
//
//    //=======================================================
//
//    //我们来看看此时会发出多少sql语句呢？同样记住一点：当session调用load、get方法时，此时如果数据库中有该对象，则该对象也变成了一个持久化对象，被session所托管。因此，这个时候如果对对象进行操作，在提交事务时同样会去与session中的持久化对象进行比较，因此这里会发送两条sql语句
//    @Test
//    public void testPersist() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = (Bill) openSession.load(Bill.class, 3);
//        load.setBillname("1");
//        System.out.println("nihaoooooo");
//        beginTransaction.commit();
//        openSession.close();
//    }
//    // 瞬时对象得insert是立即生效的,也就是执行save后立刻插入,不用等到事物提交
//    @Test
//    public void TestPersistent01() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setBillname("new save");
//        openSession.save(load);
//        System.out.println("nihaoooooo");
//        load.setBillname("new  update");
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//
//    //如果一个对象以及是持久化状态了，那么此时对该对象进行各种修改，或者调用多次update、save方法时，hibernate都不会发送sql语句，只有当事物提交的时候，此时hibernate才会拿当前这个对象与之前保存在session中的持久化对象进行比较，如果不相同就发送一条update的sql语句，否则就不会发送update语句
//    @Test
//    public void testPersist1() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = (Bill) openSession.load(Bill.class, 3);
//        load.setBillname("1");
//        openSession.save(load);
//        System.out.println("nihaoooooo");
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//
//
//
//
//
//
//
//    //我们看到，当调用了u.setId(4)时，此时u是一个离线的对象，因为数据库中存在id=4的这个对象，但是该对象又没有被session所托管，所以这个对象就是离线的对象，要使离线对象变成一个持久化的对象，应该调用什么方法呢？我们知道调用save方法，可以将一个对象变成一个持久化对象，但是，当save一执行的时候，此时hibernate会根据id的生成策略往数据库中再插入一条数据，所以如果调用save方法，此时数据库会发送一条插入的语句：
//    @Test
//    public void testPersist3() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
////        Bill load = (Bill) openSession.load(Bill.class, 3);
//        Bill load = new Bill();
//        load.setId(3);
//        load.setBillname("6");
//        openSession.save(load);
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//    //如果试图修改一个持久化对象的ID的值的话，就会抛出异常，这点要特别注意
//    //org.hibernate.HibernateException: identifier of an instance of com.xiaoluo.bean.User was altered from 5 to 333
//    @Test
//    public void testLixianToPersist() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setId(4);
//        load.setBillname("1.2");
//        openSession.update(load);
////        openSession.saveOrUpdate(load);
////        load.setBillname("3");
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//    @Test
//    public void testLixianToPersist2() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setId(3);
//        load.setBillname("1.2");
//        openSession.update(load);
////        load.setBillname("3");
//        load.setId(16);
//        beginTransaction.commit();
//        openSession.close();
//    }
//
//
//    //记住：如果对象设置了ID值，例如u.setId(4)，那么该对象会被假设当作一个离线对象，此时就会执行update操作。
//    // 未设置id值则执行insert操作
//    @Test
//    public void testShunShi2() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Bill load = new Bill();
//        load.setId(8);
//        load.setBillname("1.3");
//        openSession.saveOrUpdate(load);
//        beginTransaction.commit();
//        openSession.close();
//    }
//    //我们再来看一下这个例子，此时我们的u1已经是持久化的对象了，保存在session缓存中，u2通过调用saveOrUpdate方法后也变成了一个持久化的对象，此时也会保存在session缓存中，这个时候session缓存中就存在了一个持久化对象有两个引用拷贝了，这个时候hibernate就会报错
//    //    org.hibernate.NonUniqueObjectException: a different object with the same identifier value was already associated with the session:
//    @Test
//    public void testPersist4() throws Exception {
//        Session openSession = sf.openSession();
//        Transaction beginTransaction = openSession.beginTransaction();
//        Object load1 = openSession.load(Bill.class, 4);
//        System.out.println("load1 = " + load1);
//        Bill load = new Bill();
//        load.setId(4);
//        load.setBillname("1.4");
//        openSession.saveOrUpdate(load);
//        beginTransaction.commit();
//        openSession.close();
//    }


}
