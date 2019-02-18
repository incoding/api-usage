package com.javaapi.test.flowable.assigners;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.flowable.engine.*;
import org.flowable.engine.dynamic.DynamicProcessDefinitionSummary;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *  ProcessEngine and the services objects are thread safe,
 *  All services are stateless. This means that you can easily run Flowable on multiple nodes in a cluster, each going to the same database, without having to worry about which machine actually executed previous calls. Any call to any service is idempotent regardless of where it is executed.
 */
public class HolidayRequest {

    private ProcessEngine processEngine;

    private ProcessInstance processInstance;
    private Deployment deployment;
    private RepositoryService repositoryService;
    private RuntimeService runtimeService;

    /**
     * 可以使用docker 启动一个本地mysql
     */
//    @Before
//    public void before(){
//        // 配置数据库
//        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
//                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable?characterEncoding=UTF-8")
//                .setJdbcUsername("root")
//                .setJdbcPassword("root")
//                .setJdbcDriver("com.mysql.jdbc.Driver")
//                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//        processEngine = cfg.buildProcessEngine();
//
//        // 部署 任务
//        deploy();
//
//        startProcess();
//    }

    @Test
    public void testConfiguration(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        processEngine = cfg.buildProcessEngine();
    }

//    @Before
//    public void before(){
//        // 配置数据库
//        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
//                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
//                .setJdbcUsername("sa")
//                .setJdbcPassword("")
//                .setJdbcDriver("org.h2.Driver")
//                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//        processEngine = cfg.buildProcessEngine();
//
//        // 部署 任务
//        deploy();
//
//        startProcess();
//    }

    private void deploy() {
        repositoryService = processEngine.getRepositoryService();
        String resource = "flowable/assigners/holiday-request.bpmn20.xml";


        deployment = repositoryService.createDeployment()
                                      .addClasspathResource(resource)
                                      .deploy();
    }

    private void startProcess() {
        System.out.println("Who are you?");
        String employee = "Mr k";

        System.out.println("How many holidays do you want to request?");
        Integer nrOfHolidays = 1;

        System.out.println("Why do you need them?");
        String description = "need desc";

        runtimeService = processEngine.getRuntimeService();
        // 申请
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", employee);
        variables.put("nrOfHolidays", nrOfHolidays);
        variables.put("description", description);
        processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);
    }

    /**
     * While the RepositoryService is mostly about static information (data that doesn’t change, or at least not a lot),
     */
    @Test
    public void testRepository(){
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                                                               .deploymentId(deployment.getId())
                                                               .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());

    }

    @Test
    public void testRuntimeService(){

        startProcess();
    }

    /**
     * 可以动态添加用户
     */
    @Test
    public void testTaskServiceAddUser(){
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();

        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i+1) + ") " + task.getName());
            taskService.addCandidateUser(task.getId(),"user3");

        }

        List<Task> user1 = taskService.createTaskQuery().taskCandidateUser("user1").list();
        System.out.println("You have " + user1.size() + " tasks:");

        List<Task> user3 = taskService.createTaskQuery().taskCandidateUser("user3").list();
        System.out.println("You have " + user3.size() + " tasks:");

        List<Task> user4 = taskService.createTaskQuery().taskCandidateUser("user4").list();
        System.out.println("You have " + user4.size() + " tasks:");
    }



    @Test
    public void testTaskService(){
        // 审核列表
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }
        // 审核详情
        System.out.println("Which task would you like to complete?");
        int taskIndex = 1;
        Task task = tasks.get(taskIndex - 1);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " wants " +
                processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");
        // 审批意见
        String opinion = "y";
        boolean approved = opinion.toLowerCase().equals("y");
        Map<String,Object> variables = new HashMap<>();
        variables.put("approved", approved);
        taskService.complete(task.getId(), variables);

        // 再重新查询下任务
        tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }
    }

    @Test
    public void testHistoryService(){
        // 审批历史
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                              .processInstanceId(processInstance.getId())
                              .finished()
                              .orderByHistoricActivityInstanceEndTime().asc()
                              .list();

        for (HistoricActivityInstance activity : activities) {
            System.out.println("type "+activity.getActivityType()+" "+activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
        }
    }

    @Test
    public void testDynamicBpmnService(){
        DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
        DynamicProcessDefinitionSummary dynamicProcessDefinitionSummary = dynamicBpmnService.getDynamicProcessDefinitionSummary("");


    }
}
