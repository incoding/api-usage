
/** 主要流转如下
 Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "INIT", to = "CHECKING", event = "CREATE")
 Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "PAY_WAIT", event = "CHECK_PASS")
 Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "CANCEL", event = "CHECK_REFUSE")
 Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "PAY_WAIT", to = "COMPLETE", event = "PAY_SUCCESS")
 Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "PAY_WAIT", to = "CANCEL", event = "PAY_TIMEOUT" )
 **/
package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit;
