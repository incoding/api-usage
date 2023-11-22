package com.javaapi.test.buisness.boilerplate.dbscan;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 2020/10/7.
 */
public class DbScanTemplateDoWhile<T, U> {

    public static void main(String[] args) {
//        DeviceWithdrawAllowExpireQuery query = new DeviceWithdrawAllowExpireQuery(WithdrawAllowExpireTypeEnum.CHOOSE.getValue(), LocalDate.now());
//        IPage<DeviceWithdrawAllow> allowPage;
//        int currentPageNo = 1;
//        int pageSize = 200;
//        do {
//            log.info("查询当前第:{}页",currentPageNo);
//            allowPage = deviceWithdrawAllowDomain.selectExpirePage(query, new Page<>(currentPageNo++, pageSize));
//            if (allowPage == null || allowPage.getRecords() == null) {
//                break;
//            }
//            List<String> deviceCodes = allowPage.getRecords().stream().map(DeviceWithdrawAllow::getDeviceCode).collect(Collectors.toList());
//            log.info("当前第:{}页,移除的数据为:{}",currentPageNo,deviceCodes);
//            deviceWithdrawAllowDomain.removeByDeviceCodes(deviceCodes);
//        } while (allowPage.getRecords().size() == pageSize);
    }

}
