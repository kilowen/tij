package com.chang.tij.et;

public class Test {

	public static void main(String[] args) {
		for(BusTyp busTyp : BusTyp.values()){
			System.out.println(busTyp.getCode()+","+busTyp.getDesc());
		}
		System.out.println(BusTyp.valueOf("BUS_TYP_AGENT_SINGEL"));
		System.out.println(BusTyp.findBusTyp("0817"));
		
	}
}
