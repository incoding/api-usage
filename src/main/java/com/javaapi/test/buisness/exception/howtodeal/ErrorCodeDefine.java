package com.javaapi.test.buisness.exception.howtodeal;


public final class ErrorCodeDefine {

	/**远程接口调用报错**/
	public static final int GLB_REMOTING_ERROR = 1;
	
	/**用户未登录**/
	public static final int GLB_NO_LOGIN = 2;
	
	/**缺少必要参数(请求参数缺少)**/
	public static final int GLB_MISSING_PARAM = 3;
	
	/**参数校验错误(用户可能手动构造请求参数)**/
	public static final int GLB_WRONG_PARAM = 4;
	
	/**该用户还没有对应的vip_user_id**/
	public static final int GLB_MEMBER_NO_VIPUSERID = 5;

	
	/**----------------和任务相关的错误Start----------------------**/
	/**任务实体为空**/
	public static final int EMPTY_MISSION = 101;
	
	/**用户参与的任务是顶级任务**/
	public static final int IS_PARENT_MISSION = 102;
	
	/**任务已被删除**/
	public static final int MISSION_DELETED = 103;
	
	/**任务已过期**/
	public static final int MISSION_OVERTIME = 104;
	
	/**任务不是WEB平台**/
	public static final int MISSION_WRONG_PLATFORM = 105;
	
	/**任务已经开始**/
	public static final int MISSON_STARTED = 106;
	
	/**任务已经完成**/
	public static final int MISSON_FINISHED = 107;
	
	/**没有达到参与该任务的等级**/
	public static final int MISSON_DEGREE_REQUIRED = 108;
	
	/**任务不是闯关类型的任务**/
	public static final int MISSION_NO_BRKTR = 109;
	
	/**Vip-Mission为空**/
	public static final int EMPTY_VIPMISSION = 110;
	
	/**题目型任务为空**/
	public static final int EMPTY_EXAM_MISSION = 111;
	
	/**新手任务，限于只能是上线后注册的会员**/
	public static final int NEW_TASK_MISSION_ERR = 112;
	
	/**----------------和任务相关的错误End----------------------**/
	
	
	/**----------------和会员等级相关的错误Start----------------------**/
	
	/**会员等级实体为空**/
	public static final int EMPTY_VIPDEGREE = 201;
	
	/**未完善用户资料**/
	public static final int NO_FULL_MEMBER_INFO = 202;
	
	/**----------------和会员等级相关的错误End----------------------**/

	
	/**----------------和登陆的错误Start----------------------**/

	/**用户登陆账号为空**/
	public static final int EMPTY_ACCOUNT = 301;
	
	/**用户登陆密码为空**/
	public static final int EMPTY_PASSWORD = 302;
	
	/**用户验证码为空**/
	public static final int EMPTY_CHECKCODE = 303;
	
	/**用户验证码验证失败**/
	public static final int WRONG_CHECKCODE = 304;
	
	/**用户帐号失效**/
	public static final int ACCOUNT_INVALID = 305;
	
	/**输入参数校验错误**/
	public static final int INPUT_FIELD_ERROR = 306;
	
	/**用户名或者密码错误**/
	public static final int LOGIN_FAILURE = 307;
	
	/**----------------和登陆的错误End----------------------**/

}
