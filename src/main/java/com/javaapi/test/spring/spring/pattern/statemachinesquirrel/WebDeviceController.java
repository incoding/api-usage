package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 结合spring https://cdmana.com/2021/03/20210323150540996m.html
 * Created by user on 2021/6/1.
 */
@Slf4j
@RestController
@RequestMapping(value = "/tools/w/device", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebDeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private AbstractStateMachineEngine deviceStateMachineEngine;

    /**
     * 分配操作
     *
     * @param deviceDTO 新建资源的DTO
     * @return 新建资源
     */
    @PostMapping(name = "/assign")
    public void assign(@RequestBody  final DeviceDTO deviceDTO) {
        final Device model = convert(deviceDTO);
        model.setStatus(DeviceStatusEnum.INITIALIZE);
        DeviceContext context = new DeviceContext(model);
        deviceStateMachineEngine.fire(DeviceEvent.ASSIGN, context);
        if (log.isInfoEnabled()) {
            log.info("{} instance {} was created.", Device.class.getSimpleName(), model.getId());
        }
        return;
    }

    private Device convert(DeviceDTO deviceDTO) {
        // todo handle
        return null;
    }

}