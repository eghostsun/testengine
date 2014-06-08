package com.slf.client.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.slf.base.BaseObj;
import com.slf.bo.LsCz;
import com.slf.client.BaseClient;
import com.slf.client.IBossClient;
import com.slf.client.helper.ClientHelper;
import com.slf.common.SysContants;
import com.slf.utils.KeyedDigestMD5;


public class BossClientImpl extends BaseClient implements IBossClient {

	private static final Logger log = Logger.getLogger(BossClientImpl.class);
	private static final String CHARSET = "utf-8";
	public LsCz get()
	{
		StringBuffer url = new StringBuffer(SysContants.BOSS_URL + "/req.do?to=get");
		url.append("&tdbh=" + SysContants.TDBH);
		String sign = KeyedDigestMD5.getKeyedDigest(SysContants.TDBH,  SysContants.BOSS_KEY);
		url.append("&sign=" + sign);
		String result = this.requestUrl(url.toString(), CHARSET);
		if(result != null && !"0".equals(result) && !"".equals(result))
		{
			log.log(Priority.INFO, "get->" + result);
			JSONObject object = JSONObject.fromObject(result);
			LsCz lsCz = ClientHelper.getJsonToBean(object);
			return lsCz;
		}
		return null;
	}
	
	public BaseObj back(LsCz lsCz)
	{
		StringBuffer url = new StringBuffer(SysContants.BOSS_URL + "/req.do?to=back");
		url.append("&tdbh=" + SysContants.TDBH);
		url.append("&czid=" + lsCz.getCzid());
		url.append("&yyslsh=" + lsCz.getYyslsh());
		url.append("&sjje=" + lsCz.getSjje().intValue());
		url.append("&clbz=" + lsCz.getClbz());
		try {
			String cljg = URLEncoder.encode(new String(new Base64().encodeBase64(lsCz.getCljg().getBytes(CHARSET))), CHARSET);
			url.append("&cljg=" + cljg);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
		}
		String sign = KeyedDigestMD5.getKeyedDigest(SysContants.TDBH + lsCz.getCzid() + lsCz.getYyslsh() 
				+ lsCz.getSjje().intValue() + lsCz.getClbz() + lsCz.getCljg(), SysContants.BOSS_KEY);
		url.append("&sign=" + sign);
		log.log(Priority.INFO, "back->" + url.toString());
		String result = this.requestUrl(url.toString(), CHARSET);
		if(result != null && !"".equals(result))
		{
			JSONObject object = JSONObject.fromObject(result);
			BaseObj obj = ClientHelper.backJsonToBean(object);
			return obj;
		}
		return null;
	}
	
	public BaseObj money(int ye)
	{
		StringBuffer url = new StringBuffer(SysContants.BOSS_URL + "/channel.do?to=money");
		url.append("&tdbh=" + SysContants.TDBH);
		url.append("&ye=" + ye);
		String sign = KeyedDigestMD5.getKeyedDigest(SysContants.TDBH + ye,  SysContants.BOSS_KEY);
		url.append("&sign=" + sign);
		log.log(Priority.INFO, "money->" + url.toString());
		String result = this.requestUrl(url.toString(), CHARSET);
		if(result != null && !"".equals(result))
		{
			JSONObject object = JSONObject.fromObject(result);
			BaseObj obj = ClientHelper.backJsonToBean(object);
			return obj;
		}
		return null;
	}
	
	public BaseObj status(int fhzt)
	{
		StringBuffer url = new StringBuffer(SysContants.BOSS_URL + "/channel.do?to=status");
		url.append("&tdbh=" + SysContants.TDBH);
		url.append("&fhzt=" + fhzt);
		String sign = KeyedDigestMD5.getKeyedDigest(SysContants.TDBH + fhzt,  SysContants.BOSS_KEY);
		url.append("&sign=" + sign);
		log.log(Priority.INFO, "status->" + url.toString());
		String result = this.requestUrl(url.toString(), CHARSET);
		if(result != null && !"".equals(result))
		{
			JSONObject object = JSONObject.fromObject(result);
			BaseObj obj = ClientHelper.backJsonToBean(object);
			return obj;
		}
		return null;
	}
}
