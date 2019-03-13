package com.javaapi.test.buisness.joint.result.base;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 */
public class BaseResultTest {

    /**
     * test ok
     */
    @Test
    public void testRealBusiness_one_right() throws Exception {
        BaseResult<Object> result = BaseResult.ok();
        String username = null;
        String password = null;
        int age = 0;
        BaseResult<Object> baseResult = validParamRight(username, password, age, result);
        if (baseResult.failed()) {
            System.out.println("响应错误=="+JSON.toJSONString(baseResult));
            return;
        }
        HashMap<Object, Object> data = new HashMap<>();
        data.put("nihao", "222");
        data.put("nihao3", "333");

        baseResult.setData(data);

        System.out.println(JSON.toJSONString(baseResult));
    }

    /**
     * * test error case 1
     * @throws Exception
     */
    @Test
    @Deprecated
    public void testRealBusiness_one_error() throws Exception {
        BaseResult<Object> result = BaseResult.ok();
        String username = null;
        String password = null;
        int age = 0;
        BaseResult<Object> baseResult = validParam(username, password, age, result);
        if (baseResult.failed()) {
            System.out.println("响应错误=="+JSON.toJSONString(baseResult));
            return;
        }
        HashMap<Object, Object> data = new HashMap<>();
        data.put("nihao", "222");
        data.put("nihao3", "333");

        baseResult.setData(data);

        System.out.println(JSON.toJSONString(baseResult));
    }

    /**
     * test error case 2
     * @throws Exception
     */
    @Test
    @Deprecated
    public void testRealBusiness_one_error2() throws Exception {
        BaseResult<Object> result = BaseResult.ok();
        String username = null;
        String password = null;
        int age = 0;
        BaseResult<Object> baseResult = validParamOneError(username, password, age, result);
        if (baseResult.failed()) {
            System.out.println("响应错误=="+JSON.toJSONString(baseResult));
            return;
        }
        HashMap<Object, Object> data = new HashMap<>();
        data.put("nihao", "222");
        data.put("nihao3", "333");

        baseResult.setData(data);

        System.out.println(JSON.toJSONString(baseResult));
    }

    /**
     * test errorList
     * check more one error one time benefits from error list
     * @throws Exception
     */
    @Test
    public void testRealBusiness_error_list() throws Exception {
        BaseResult<Object> baseResult = BaseResult.ok();
        String username = "username_2";
        String password = "password_2";
        int age = 0;
        baseResult = validParamForErrorList(username, password, age, baseResult);
        System.out.println("httpResult = " + JSON.toJSONString(baseResult));
    }

    /**
     * test error check case
     * @throws Exception
     */
    @Test
    public void testRealBusiness_error_list2() throws Exception {
        String username = "username_2";
        String password = "password_2";
        int age = 0;
        BaseResult<Object> result = bussiness1(username, password);
        if (result.failed()) {
//            return result
        }
        Object data = result.getData();
        System.out.println("use data = " + data);
        BaseResult<Object> result2 = bussiness2(username, password);
        System.out.println("result2 = " + result2.getData());
        if (result2.failed()) {
//            return result2
        }
        BaseResult<Object> result3 = bussiness3(username, password);
        System.out.println("result3 = " + result3.getData());
        if (result3.failed()) {
//            return result3
        }
    }


    @Test
    public void testSuccess() {
        System.out.println(JSON.toJSONString(BaseResult.ok()));
        System.out.println(JSON.toJSONString(BaseResult.ok("这是返回的结果")));
    }

    /**
     *code 为common ,则直接提示错误的msg
      */

    @Test
    public void testOk() {
        BaseResult<String> nihao = BaseResult.ok("nihao");
        System.out.println(JSON.toJSONString(nihao));
    }

    @Test
    public void testOk_v2() {
        List<String> objects = new ArrayList<>();
        objects.add("nihao");
        objects.add("nihao");
        objects.add("nihao");
        BaseResult<List<String>> nihao = BaseResult.ok(objects);
        System.out.println(JSON.toJSONString(nihao));
        List<String> data = nihao.getData();
        System.out.println(data);
    }

    @Test
    public void testError() {
        BaseResult<Object> nihao = BaseResult.displayError("请先登录");
        System.out.println(JSON.toJSONString(nihao));
    }

    @Test
    public void testErrorCode() {
        BaseResult<Object> nihao = BaseResult.error("need.login", "请先登录");
        System.out.println(JSON.toJSONString(nihao));
    }

    @Test
    public void testErrorList() {
        BaseResult<Object> nihao = BaseResult.errorList(new BaseError("need.login", "请先登录"))
                                             .errorListAdd("need.item.2", "条件2不符合");
        System.out.println(JSON.toJSONString(nihao));
    }

    @Test
    public void testErrorList_v2() {
        BaseResult<Object> nihao = BaseResult.errorList("need.item.1", "条件1不符合")
                                             .errorListAdd("need.item.2", "条件2不符合");
        System.out.println(JSON.toJSONString(nihao));
    }

    @Test
    public void testErrorForValid() {
        String username = null;
        String password = null;
        int age = 0;
        BaseResult<Object> baseResult = validParam(username, password, age);
        if (baseResult.failed()) {
            System.out.println(JSON.toJSONString(baseResult));
        }
    }

    @Test
    public void testErrorForValid_v2() {

        String username = "usernamea";
        String password = "password";
        int age = 0;
        BaseResult<Object> baseResult = validParamForErrorList(username, password, age);
        if (baseResult.failed()) {
            System.out.println(JSON.toJSONString(baseResult));
        } else {
            System.out.println("chenggong");
            System.out.println(JSON.toJSONString(baseResult));
        }
    }

    private <T> BaseResult<T> validParam(String username, String password, int age) {
        if (!"a".equals(username)) {
            return BaseResult.displayError("username 不正确");
        }
        if (!"p".equals(password)) {
            return BaseResult.displayError("password 不正确");
        }
        return BaseResult.ok();
    }

    private <T> BaseResult<T> validParamForErrorList(String username, String password, int age) {
        BaseResult<T> result = BaseResult.ok();
        if (!"username".equals(username)) {
            result.errorListAdd("username is wrong", "username不正确");
        }
        if (!"password".equals(password)) {
            result.errorListAdd("password is wrong", "password不正确");
        }
        return result;
    }

    private <T> BaseResult<T> validParamForErrorList(String username, String password, int age, BaseResult baseResult) {
        if (!"username".equals(username)) {
            baseResult.errorListAdd("username is wrong", "username不正确");
        }
        if (!"password".equals(password)) {
            baseResult.errorListAdd("password is wrong", "password不正确");
        }
        return baseResult;
    }

    private <T> BaseResult<T> validParamRight(String username, String password, int age, BaseResult<T> baseResult) {
        return baseResult;
    }

    private <T> BaseResult<T> validParam(String username, String password, int age, BaseResult<T> baseResult) {
        if (!"a".equals(username)) {
            return BaseResult.displayError("username 不正确");
        }
        if (!"p".equals(password)) {
            return BaseResult.displayError("password 不正确");
        }
        return baseResult;
    }

    private <T> BaseResult<T> validParamOneError(String username, String password, int age, BaseResult<T> baseResult) {
        if (!"a".equals(username)) {
            return BaseResult.error(BaseError.NEED_LOGIN);
        }
        BaseResult.error(BaseError.SYS_ERR);
        return baseResult;
    }


    private <T> BaseResult<T> bussiness1(String username, String password) {
        if (!"a".equals(username)) {
            return BaseResult.error(BaseError.NEED_LOGIN);
        }
        return BaseResult.error(BaseError.SYS_ERR);
    }

    private <T> BaseResult<T> bussiness2(String username, String password) {
        if (!"p".equals(password)) {
            return BaseResult.displayError("password 不正确");
        }
        return BaseResult.error(BaseError.SYS_ERR);
    }

    private <T> BaseResult<T> bussiness3(String username, String password) {
        if (!"a".equals(password)) {
            return BaseResult.displayError("password 不正确");
        }
        return BaseResult.error(BaseError.SYS_ERR);
    }


}
