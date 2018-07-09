package com.javaapi.test.application.rpc.hessian;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring生成的代理配置成prototype，无法通过name获取 - -
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("remoting-core-service-client.xml")
public class Client {

//	@Autowired
//	@Qualifier("issueManagerService")
//	IssueManagerService issueManagerService;
//
//	@Test
//	public void test() {
//		BetGameIssue issue = issueManagerService.getPrevIssue(Game.JJ_DCSF);
//		System.out.println("---------------==>");
//		System.out.println(issue.getIssueNo());
//		System.out.println("---------------==>");
//	}
}
