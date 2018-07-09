package com.javaapi.test.buisness.constant.enumIndexDesc;

import java.util.List;


public enum CashTradeIn_task  implements IndexIntDesc{
//	SHENHE(0, "待审核"),
	FUHE(1, "待复核"),
	DAKUAN(2, "待打款"),
	SHIBAI(3, "交易失败"),
	CHENGGONG(4, "交易成功"),
	DAKUANZHONG(5,"银行打款中");
	private Integer index;

	private String desc;

	public static CashTradeIn_task getByIndex(Integer key) {
		CashTradeIn_task result = EnumUtils.getEnum(CashTradeIn_task.class, key);
		return result;
	}
	public static CashTradeIn_task getByDesc(String desc) {
		CashTradeIn_task result= EnumUtils.getEnum(CashTradeIn_task.class, desc);
		return result;
	}
	public static List<CashTradeIn_task> getAllType() {
		List<CashTradeIn_task> allType = EnumUtils.getAllType(CashTradeIn_task.class);
		return allType;
	}
	private CashTradeIn_task(Integer index, String desc) {
		this.index = index;
		this.desc = desc;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}