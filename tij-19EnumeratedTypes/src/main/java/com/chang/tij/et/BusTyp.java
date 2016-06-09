package com.chang.tij.et;

public enum BusTyp {

	BUS_TYP_AGENT_BATCH("0812", "批量代扣"), BUS_TYP_AGENT_SINGEL("0817", "单笔代扣");

	private String code;
	private String desc;

	private BusTyp(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}

	static BusTyp findBusTyp(String code) {
		for (BusTyp busTyp : BusTyp.values()) {
			if (code.equals(busTyp.getCode())) {
				return busTyp;
			}
		}
		return null;
	}

}
