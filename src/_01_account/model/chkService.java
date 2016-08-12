package _01_account.model;

import java.util.List;

import org.json.JSONObject;

import _01_account.dao.Accjdbc;

public class chkService {
	private Accjdbc accjdbc = new Accjdbc();
	
	public JSONObject login(String acc, String psd) {
		JSONObject json = new JSONObject();
		boolean respose = false;
		json.put("AccUid","");
		
		List bean = accjdbc.select(acc);
		if (!bean.isEmpty()) {
			JSONObject obj = (JSONObject) bean.get(0);
			if (psd.equals(obj.getString("Pwd"))) {
				respose = true;
				json.put("AccUid",obj.getString("AccUid"));
			}else{
				JSONObject json2 = new JSONObject();
				json2.put("clientCode","000");
				json2.put("portOfLoading","帳號或密碼錯誤");
				json.put("errors",json2);
			}
		}else{
			JSONObject json2 = new JSONObject();
			json2.put("clientCode","000x");
			json2.put("portOfLoading","無效帳號");
			json.put("errors",json2);
		}
		json.put("success",respose);
		
		return json;
	}
}
