package com.slf.common;

import com.slf.utils.ReadProperties;



public interface SysContants {

	public static final String PROP_FILE_NAME = "conf/engine.properties";
	public static final String BOSS_KEY = ReadProperties.getProp(PROP_FILE_NAME).getProperty("boss.key");
	public static final String BOSS_URL = ReadProperties.getProp(PROP_FILE_NAME).getProperty("boss.url");
	
	public static final String DEFAULT_CHARASET = "utf-8";
	
	
	public static final String TDBH = ReadProperties.getProp(PROP_FILE_NAME).getProperty("tdbh");
	public static final String CLBZ = ReadProperties.getProp(PROP_FILE_NAME).getProperty("clbz");
	
}
