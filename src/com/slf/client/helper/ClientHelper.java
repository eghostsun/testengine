package com.slf.client.helper;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

import com.slf.base.BaseObj;
import com.slf.bo.LsCz;

public class ClientHelper {

	public static LsCz getJsonToBean(JSONObject object)
	{
		LsCz lsCz = new LsCz();
		lsCz.setCzid(object.getLong("czid"));
		lsCz.setYysbh(object.getString("yysbh"));
		lsCz.setSsdq(object.getString("ssdq"));
		lsCz.setBczsjh(object.getString("bczsjh"));
		lsCz.setCzje(BigDecimal.valueOf(object.getLong("czje")));
		lsCz.setPlwjid(object.getLong("plwjid"));
		lsCz.setTdzh(object.getString("tdzh"));
		lsCz.setTdmm(object.getString("tdmm"));
		return lsCz;
	}
	
	public static BaseObj backJsonToBean(JSONObject object)
	{
		BaseObj obj = new BaseObj();
		obj.setRetCode(object.getInt("retCode"));
		obj.setRetMsg(object.getString("retMsg"));
		return obj;
	}
}
