package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

/**
 * Created by user on 2021/6/1.
 */
@States({
        @State(name = "INITIALIZE", entryCallMethod = "entryStateInit", exitCallMethod = "exitStateInit", initialState = true),
        @State(name = "RUNNING", entryCallMethod = "entryStateRunning", exitCallMethod = "exitStateRunning"),
        @State(name = "TO_BE_MAINTAINED", entryCallMethod = "entryStateMaintained", exitCallMethod = "exitStateMaintained"),
        @State(name = "TO_BE_SCRAPPED", entryCallMethod = "entryStateScrap", exitCallMethod = "exitStateScrap"),
        @State(name = "UNBOUND", entryCallMethod = "entryStateUnbound", exitCallMethod = "exitStateUnbound")
})
@Transitions({
        @Transit(from = "INITIALIZE", to = "RUNNING", on = "ASSIGN", callMethod = "assign"),
        @Transit(from = "RUNNING", to = "TO_BE_MAINTAINED", on = "BEYOND_MAINTENANCE", callMethod = "beyondMaintenance"),
        @Transit(from = "RUNNING", to = "TO_BE_SCRAPPED", on = "SCRAP", callMethod = "scrap"),
        @Transit(from = "RUNNING", to = "UNBOUND", on = "UNBIND", callMethod = "unbind"),
        @Transit(from = "TO_BE_MAINTAINED", to = "UNBOUND", on = "UNBIND", callMethod = "unbind"),
        @Transit(from = "TO_BE_MAINTAINED", to = "RUNNING", on = "CHECK_IN", callMethod = "checkIn"),
        @Transit(from = "TO_BE_SCRAPPED", to = "UNBOUND", on = "UNBIND", callMethod = "unbind"),
        @Transit(from = "UNBOUND", to = "RUNNING", on = "ASSIGN", callMethod = "assign")
})
@StateMachineParameters(stateType = DeviceStatusEnum.class, eventType = DeviceEvent.class, contextType = DeviceContext.class)
@Slf4j
public class DeviceManagementStateMachine extends AbstractStateMachine<UntypedStateMachine, Object, Object, Object> implements UntypedStateMachine {
    private DeviceService deviceService;

    protected ApplicationContext applicationContext;

    //定义构造函数接受ApplicationContext注入
    public DeviceManagementStateMachine(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        // 通过applicationContext注入deviceService
        this.deviceService = (DeviceService) this.applicationContext.getBean("deviceService");
    }

    public void assign(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        this.deviceService.save(context.getModel());
    }

    public void beyondMaintenance(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("beyondMaintenance", fromState, toState, event, context);
    }

    public void scrap(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("scrap", fromState, toState, event, context);
    }

    public void unbind(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("unbind", fromState, toState, event, context);
    }

    public void checkIn(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("checkIn", fromState, toState, event, context);
    }

    public void entryStateUnbound(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("entryStateUnbound", fromState, toState, event, context);
    }

    public void exitStateUnbound(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("entryStateUnbound", fromState, toState, event, context);
    }

    public void entryStateRunning(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("entryStateRunning", fromState, toState, event, context);
    }

    public void exitStateRunning(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("exitStateRunning", fromState, toState, event, context);
    }

    public void entryStateMaintained(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("entryStateMaintained", fromState, toState, event, context);
    }

    public void exitStateMaintained(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("exitStateMaintained", fromState, toState, event, context);
    }

    public void entryStateScrap(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("entryStateScrap", fromState, toState, event, context);
    }

    public void exitStateScrap(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("exitStateScrap", fromState, toState, event, context);
    }

    public void entryStateInit(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("entryStateInit", fromState, toState, event, context);
    }

    public void exitStateInit(DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        loggered("exitStateInit", fromState, toState, event, context);
    }

    private void loggered(String msg, DeviceStatusEnum fromState, DeviceStatusEnum toState, DeviceEvent event, DeviceContext context) {
        StringBuilder sb = new StringBuilder(msg);
        sb.append(" ==> fromState: ").append(fromState).append("; ");
        sb.append("toState: ").append(toState).append("; ");
        sb.append("event: ").append(event).append("; ");
        sb.append("context: ").append(context.getModel()).append("; ");
        log.info(sb.toString());
    }
}
