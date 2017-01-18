package _02_MenuTree;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import _02_MenuTree.dao.Treejdbc;

public class makeTreeService {
	private Treejdbc treejdbc = new Treejdbc();
	List bean = null;
	private JSONObject jsonTree = null;
	
	public JSONObject exct() {
		bean = treejdbc.select();
		jsonTree = new JSONObject();
		JSONObject objroot = null;										//用來擺放root的物件
		JSONArray bagJsAry = new JSONArray();
		ArrayList<Integer> bunchNum  = new ArrayList<>();
		
		//從最下層的先分類，把一個個樹葉分類
		for (int i = bean.size()-1; i >= 0; i--) {
			JSONArray bunchJsAry = new JSONArray();						//這個陣列的目的是為了把父階層一樣的子階層放一起
			JSONObject obj = (JSONObject)bean.get(i);
			//同個子階層串接起來，唯獨不串CLASS_NODE=0
			if(obj.getString("excute")=="1" && !obj.getString("CLASS_NODE").equals("0")){
				bunchJsAry.put(plantLeaf(obj,bagJsAry,bunchNum));
				obj.put("excute", "0");									//這個註記是為了已經處理過的資料不再處理一次
				
				for (int y = bean.size()-1; y >= 0; y--) {
					JSONObject tmpobj = (JSONObject)bean.get(y);
					if(tmpobj.getString("up_class_node").equals(obj.getString("up_class_node")) && tmpobj.getString("excute")=="1"){	
//						System.out.println("分類果實>> "+tmpobj.getString("CLASS_NODE"));
						bunchJsAry.put(plantLeaf(tmpobj,bagJsAry,bunchNum));
						tmpobj.put("excute", "0");						//這個註記是為了已經處理過的資料不再處理一次
					}
				}
				bagJsAry.put(bunchJsAry);
				bunchNum.add(Integer.valueOf(obj.getString("up_class_node")));
			}else if(obj.getString("excute")=="1" && obj.getString("CLASS_NODE").equals("0")){			//CLASS_NODE=0提出來另外放
				objroot = obj;
			}
        }	
		System.out.println("袋子的東西>>"+bagJsAry);
		if(bagJsAry.length()>0){
			JSONArray node =(JSONArray) bagJsAry.get(bagJsAry.length()-1);
			jsonTree = plantMainBranch(objroot,node);	
		}
		
		
		return jsonTree;
	}	
	
	private JSONObject plantLeaf(JSONObject obj,JSONArray bagJsAry,ArrayList<Integer> bunchNum){
		JSONObject reObj = new JSONObject();
		reObj = obj;
		reObj.put("text",obj.getString("CLASS_NODE_DESC"));
		if(obj.getString("IS_LEAF").equals("Y"))
		{
			reObj.put("leaf",true);
		}else{
			reObj.put("expanded",true);
			//當確定不是葉子的時候，就去找符合自己階層(CLASS_NODE)的父階層(up_class_node)，去put到children裡
			for (int i = 0; i < bunchNum.size(); i++) {
				int node = Integer.valueOf(obj.getString("CLASS_NODE"));
				if(bunchNum.get(i).equals(node)){
					JSONArray sort = new JSONArray();
					JSONArray tmp = (JSONArray) bagJsAry.get(i);
					//加下列這個迴圈的原因是為了要正序，因為一開始用倒序取值分類，回歸到畫面顯示，需要轉回成正序
					for(int x = tmp.length()-1; x >= 0; x--) {
						sort.put(tmp.get(x));
					}
					bagJsAry.put(i,"");			//將子階層的果實串塞到父階層後就清空掉在袋子裡的空間
					reObj.put("children",sort);
				}
			}
		}
		return reObj;
	}
	
	private JSONObject plantMainBranch(JSONObject obj,JSONArray json2Ary){
		JSONObject reObj = new JSONObject();
		reObj = obj;
		reObj.put("text",obj.getString("CLASS_NODE_DESC"));
		reObj.put("expanded",true);
		JSONArray sort = new JSONArray();
		//加下列這個迴圈的原因是為了要正序，因為一開始用倒序分類，回歸到畫面顯示，需要轉回成正序
		for(int x = json2Ary.length()-1; x >= 0; x--) {
			sort.put(json2Ary.get(x));
		}
		reObj.put("children",sort);
		return reObj;
	}
}
