package com.slf.base;


public class BaseObj{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int retCode;
	private String retMsg;
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
}
