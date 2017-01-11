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
@WebServlet(
		urlPatterns={"/_02_MenuTree/CountryServlet.controller"}
		)
public class menuTreeServlet extends HttpServlet{
	private makeTreeService treeService = new makeTreeService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		JSONObject json = new JSONObject();
		JSONArray jsAry = new JSONArray();
		treeService.exct();
		try {						
			json.put("text","detention");
			json.put("leaf",true);
			jsAry.put(json);
			
			JSONObject json1 = new JSONObject();
			json1.put("text","homework");
			json1.put("leaf",true);
			jsAry.put(json1);
			
			JSONObject json2 = new JSONObject();
			JSONArray json2Ary = new JSONArray();
			
			JSONObject json21 = new JSONObject();
			json21.put("text","book report");
			json21.put("leaf",true);
			json2Ary.put(json21);
			
			JSONObject json22 = new JSONObject();
			json22.put("text","algebra");
			json22.put("leaf",true);
			json2Ary.put(json22);
			
			
			json2.put("text","buy1 lottery tickets");
			json2.put("expanded",true);
			json2.put("children",json2Ary);
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
