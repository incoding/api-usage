package com.javaapi.test.application.spel.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PubBidPriceDayaheadAvgEntity  {

    private LocalDate targetDate;

    private String provName;

    private String timeperiod96;

    private BigDecimal priceAvg;

    private String transactionDirection;

    private String guid;



}
