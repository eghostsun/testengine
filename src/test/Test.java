package test;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.slf.bo.LsCz;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = "{\"czid\":123123123,\"name\":\"\"}";
		JSONObject object = JSONObject.fromObject(json);
		JsonConfig config = new JsonConfig();
		config.setIgnoreTransientFields(true);
		LsCz lsCz = new LsCz();
		lsCz = (LsCz) JSONObject.toBean(object, lsCz, config);
	}

}
