package _02_MenuTree;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import _02_MenuTree.dao.Treejdbc;

public class makeTreeService {
	private Treejdbc treejdbc = new Treejdbc();
	
	public JSONObject exct() {
		JSONObject json = new JSONObject();
		List JSONObjectList = new LinkedList();
		
		
		List bean = treejdbc.select();
		JSONObject obj = (JSONObject) bean.get(0);
		System.out.println("123 "+obj.getString("excute"));
		System.out.println("245 "+obj.getString("IS_LEAF"));
		
		return json;
	}
}
