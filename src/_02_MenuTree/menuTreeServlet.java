package _02_MenuTree;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import _01_account.model.chkService;
@WebServlet(
		urlPatterns={"/_02_MenuTree/CountryServlet.controller"}
		)
public class menuTreeServlet extends HttpServlet{
	private chkService chkService = new chkService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		JSONObject json = new JSONObject();
		JSONArray jsAry = new JSONArray();
		try {			
			//json = chkService.login(acc, pwd);
//			if(json.get("AccUid")!=null){
//				System.out.println(json.get("AccUid"));				
//			}
			json.put("text","detention");
			json.put("leaf",true);
			jsAry.put(json);
			JSONObject json1 = new JSONObject();
			json1.put("text","homework");
			json1.put("leaf",true);
			jsAry.put(json1);
			JSONObject json2 = new JSONObject();
			json2.put("text","buy lottery tickets");
			json2.put("leaf",true);
			jsAry.put(json2);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		System.out.println(jsAry.toString());
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().write(jsAry.toString());
	}

}
