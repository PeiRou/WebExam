package _03_ante;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import _01_account.model.mappingTree;
@WebServlet(
		urlPatterns={"/_03_ante/loadAnte.controller"}
		)
public class loadAnte extends HttpServlet{
	private mappingTree chkService = new mappingTree();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		JSONObject jsonRequest = new JSONObject(request.getParameter("loginData"));
		String acc = jsonRequest.getString("username");
		String pwd = jsonRequest.getString("password");
		System.out.println(acc);
		
		JSONObject json = new JSONObject();
		
		try {			
			json = chkService.login(acc, pwd);
			if(json.get("AccUid")!=null){
				System.out.println(json.get("AccUid"));				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		System.out.println(json.toString());
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().write(json.toString());
	}

}
