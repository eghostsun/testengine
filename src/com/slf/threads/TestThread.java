package com.slf.threads;

import java.math.BigDecimal;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.slf.bo.LsCz;
import com.slf.client.IBossClient;
import com.slf.client.impl.BossClientImpl;
import com.slf.common.SysContants;

public class TestThread extends Thread {

	private static final Logger log = Logger.getLogger(TestThread.class);
	private IBossClient bossClient = null;
	public TestThread()
	{
		log.log(Priority.INFO, "TestThread is Run");
		if(bossClient == null)
		{
			bossClient = new BossClientImpl();
		}
	}
	public void run()
	{
		while(true)
		{
			LsCz lsCz = bossClient.get();
			if(lsCz != null)
			{
				if(SysContants.CLBZ.equals("1"))
				{
					lsCz.setYyslsh(RandomStringUtils.randomNumeric(10));
					lsCz.setSjje(lsCz.getCzje());
					lsCz.setClbz(SysContants.CLBZ);
					lsCz.setCljg("充值成功");
				}else if(SysContants.CLBZ.equals("2")){
					lsCz.setClbz(SysContants.CLBZ);
					lsCz.setCljg("充值失败");
					lsCz.setSjje(BigDecimal.ZERO);
				}else{
					lsCz.setClbz(SysContants.CLBZ);
					lsCz.setCljg("查询超时");
					lsCz.setSjje(BigDecimal.ZERO);
				}
				bossClient.back(lsCz);
			}else{
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
			}
		}
	}
}
