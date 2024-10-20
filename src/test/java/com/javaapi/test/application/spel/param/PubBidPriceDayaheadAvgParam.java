package com.javaapi.test.application.spel.param;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class PubBidPriceDayaheadAvgParam {

    @NotNull(message = "数据日期不能为空")
    private String infoDate;


    private List<PubBidPriceDayaheadAvgDto> dataList;
}
