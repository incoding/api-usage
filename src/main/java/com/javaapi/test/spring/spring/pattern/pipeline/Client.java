package com.javaapi.test.spring.spring.pattern.pipeline;

import com.javaapi.test.spring.spring.pattern.pipeline.context.impl.InstanceBuildContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2021/4/4.
 * refer https://developer.aliyun.com/article/778865
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Resource
    PipelineExecutor pipelineExecutor;

    @Test
    public void test() {
        InstanceBuildRequest request = getRequest();

        InstanceBuildContext data = createPipelineData(request);
        boolean success = pipelineExecutor.acceptSync(data);
        System.out.println("success = " + success);

    }

    private InstanceBuildRequest getRequest() {
        InstanceBuildRequest request = new InstanceBuildRequest();
        request.setModelId(1L);
        request.setUserId(2L);
        HashMap<String, Object> formInput = new HashMap<>();
        formInput.put("instanceName", "this is instanceName");
        request.setFormInput(formInput);
        return request;
    }

    private InstanceBuildContext createPipelineData(InstanceBuildRequest request) {
        InstanceBuildContext instanceBuildContext = new InstanceBuildContext();
        instanceBuildContext.setModelId(request.getModelId());
        instanceBuildContext.setUserId(request.getUserId());
        instanceBuildContext.setFormInput(request.getFormInput());
        return instanceBuildContext;
    }

    public static class InstanceBuildRequest {
        private Long modelId;
        private Long userId;
        Map<String, Object> formInput;

        public Long getModelId() {
            return modelId;
        }

        public void setModelId(Long modelId) {
            this.modelId = modelId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Map<String, Object> getFormInput() {
            return formInput;
        }

        public void setFormInput(Map<String, Object> formInput) {
            this.formInput = formInput;
        }
    }
}
