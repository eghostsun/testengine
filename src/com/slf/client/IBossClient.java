package com.slf.client;

import com.slf.base.BaseObj;
import com.slf.bo.LsCz;


public interface IBossClient {

	public LsCz get();
	public BaseObj back(LsCz lsCz);
	public BaseObj money(int ye);
	public BaseObj status(int fhzt);
}
