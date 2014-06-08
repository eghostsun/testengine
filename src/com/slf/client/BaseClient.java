package com.slf.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


public class BaseClient {

	private static final Logger log = Logger.getLogger(BaseClient.class);
	
	protected String requestUrl(String url,String charset)
	{
		BufferedReader instream = null;
		URL httpUrl = null;
		StringBuffer result = new StringBuffer();
		try {
			httpUrl = new URL(url);
			instream = new BufferedReader(new InputStreamReader(httpUrl.openStream(),charset));
		    String s = null;
            while((s = instream.readLine()) != null)
            {
                    result.append(s);
            }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.log(Priority.ERROR, "url req error:" + e.getMessage());
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.log(Priority.ERROR, "url req error:" + e.getMessage());
			return null;
		}finally {
			if(instream != null)
	    	{
	    		try {
					instream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
	    	}
		}
		return result.toString();
	}
}
