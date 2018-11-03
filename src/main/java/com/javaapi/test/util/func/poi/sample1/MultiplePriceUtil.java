package com.javaapi.test.util.func.poi.sample1;

/**
 * Created by user on 18/1/10.
 */
public class MultiplePriceUtil {
    // 各个字段的index
    public static final int ID = 0;
    public static final int AIRLINE = 1;
    public static final int TRIP_TYPE = 2;
    public static final int DEP = 3;
    public static final int ARR = 4;
    public static final int FLIGHT_NO = 5;
    public static final int AVAIL_FLIGHT = 6;
    public static final int CODE = 7;
    public static final int STANDARD_PRICE = 8;
    public static final int CALCULATE_CODE = 9;
    public static final int CALCULATE_PRICE = 10;
    public static final int FORMULA_PERCENT = 11;
    public static final int FORMULA_NUM = 12;
    public static final int RESERVE = 13;
    public static final int ROUND_MODEL = 14;
    public static final int SALE_PRICE = 15;
    public static final int TICKET_PRICE = 16;
    public static final int COST_PRICE = 17;
    public static final int STANDARD = 18;
    public static final int OIL_TAX = 19;
    public static final int AIRPORT_TAX = 20;
    public static final int MATCH_ORIGIN = 21;
    public static final int VALID_START_TIME = 22;
    public static final int VALID_END_TIME = 23;
    public static final int ISSUE_START_TIME = 24;
    public static final int ISSUE_END_TIME = 25;
    public static final int BEFORE_DAYS = 26;
    public static final int AUTO_ORDER = 27;
    public static final int ORDER_COMMAND = 28;
    public static final int FD_ITEM = 29;
    public static final int OFFICE_NO = 30;
    public static final int PNR = 31;
    public static final int FB = 32;
    public static final int PASSENGER_TYPE = 33;
    public static final int ENDORSE_NOTE = 34;
    public static final int REFUND_NOTE = 35;
    public static final int CHANGE_NOTE = 36;
    public static final int RETURN_AMOUNT = 37;
    public static final int ACTIVITY_ID = 38;
    public static final int RETURN_NOTE = 39;
    public static final int CHANNEL = 40;
    public static final int REMARK = 41;

    /**
     * 单程 1 全部 2
     * @param param
     * @return
     */

    public static Integer transTripType(String param) {
        if ("全部".equalsIgnoreCase(param)) {
            return 2;
        }
        return 1;
    }
}
