package _01_account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.json.JSONObject;

public class Accjdbc {
	private DataSource dataSource;

	public Accjdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/xxx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT_BY_ID = "select * from tblAcc where acc=?";

	public List select(String acc) {
		List JSONObjectList = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			stmt.setString(1, acc);
			rset = stmt.executeQuery();

			JSONObjectList = new LinkedList();
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("AccUid", rset.getString("Acc_Uid"));
				obj.put("Pwd", rset.getString("Pwd"));
				JSONObjectList.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return JSONObjectList;
	}
}
