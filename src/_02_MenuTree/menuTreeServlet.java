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
		System.out.println("開始鏟土囉");
		try {						
			json = treeService.exct();
			jsAry.put(json);			
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
