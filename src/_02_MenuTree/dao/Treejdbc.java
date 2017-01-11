package _02_MenuTree.dao;

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

public class Treejdbc {
	private DataSource dataSource;

	public Treejdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/xxx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private final String SELECT = "select case when up_class_node IS NOT NULL then up_class_node else 0 end as up_class_node_DSY,* from ROU_DYNAMIC_TREE_PARM_VAL ORDER BY up_class_node_DSY,CLASS_LEVEL,CLASS_NODE";

	public List select() {
		List JSONObjectList = null;
		ResultSet rset = null;
		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT);) {
//			stmt.setString(1, acc);
			rset = stmt.executeQuery();

			JSONObjectList = new LinkedList();
			while (rset.next()) {
				JSONObject obj = new JSONObject();
				obj.put("PROD_CDE", rset.getString("PROD_CDE"));
				obj.put("PROD_DESC", rset.getString("PROD_DESC"));
				obj.put("CLASS_NODE", rset.getString("CLASS_NODE"));
				obj.put("CLASS_NODE_DESC", rset.getString("CLASS_NODE_DESC"));
				obj.put("CLASS_LEVEL", rset.getString("CLASS_LEVEL"));
				obj.put("IS_TOP", rset.getString("IS_TOP"));
				obj.put("IS_LEAF", rset.getString("IS_LEAF"));
				obj.put("up_class_node", rset.getString("up_class_node"));
				obj.put("excute", false);
//				obj.put("RECRATE_1_PARM_VAL", rset.getString("RECRATE_1_PARM_VAL"));
//				obj.put("RECRATE_1_SRC_CNT", rset.getString("RECRATE_1_SRC_CNT"));
//				obj.put("RECRATE_2_PARM_VAL", rset.getString("RECRATE_2_PARM_VAL"));
//				obj.put("RECRATE_2_SRC_CNT", rset.getString("RECRATE_2_SRC_CNT"));
//				obj.put("RECRATE_3_PARM_VAL", rset.getString("RECRATE_3_PARM_VAL"));
//				obj.put("RECRATE_3_SRC_CNT", rset.getString("RECRATE_3_SRC_CNT"));
//				obj.put("RECRATE_4_PARM_VAL", rset.getString("RECRATE_4_PARM_VAL"));
//				obj.put("RECRATE_4_SRC_CNT", rset.getString("RECRATE_4_SRC_CNT"));
//				obj.put("RECRATE_5_PARM_VAL", rset.getString("RECRATE_5_PARM_VAL"));
//				obj.put("RECRATE_5_SRC_CNT", rset.getString("RECRATE_5_SRC_CNT"));
//				obj.put("EXP_LOSS_RATE_PARM_VAL", rset.getString("EXP_LOSS_RATE_PARM_VAL"));
//				obj.put("EXP_LOSS_RATE_1_ALL_CNT", rset.getString("EXP_LOSS_RATE_1_ALL_CNT"));
//				obj.put("EXP_LOSS_RATE_1_END_CNT", rset.getString("EXP_LOSS_RATE_1_END_CNT"));
//				obj.put("EXP_LOSS_RATE_1_EXPRATE", rset.getString("EXP_LOSS_RATE_1_EXPRATE"));
//				obj.put("EXP_LOSS_RATE_1_VERSION", rset.getString("EXP_LOSS_RATE_1_VERSION"));
//				obj.put("EXP_LOSS_RATE_2_ALL_CNT", rset.getString("EXP_LOSS_RATE_2_ALL_CNT"));
//				obj.put("EXP_LOSS_RATE_2_END_CNT", rset.getString("EXP_LOSS_RATE_2_END_CNT"));
//				obj.put("EXP_LOSS_RATE_2_EXPRATE", rset.getString("EXP_LOSS_RATE_2_EXPRATE"));
//				obj.put("EXP_LOSS_RATE_2_VERSION", rset.getString("EXP_LOSS_RATE_2_VERSION"));
//				obj.put("EXP_LOSS_RATE_3_ALL_CNT", rset.getString("EXP_LOSS_RATE_3_ALL_CNT"));
//				obj.put("EXP_LOSS_RATE_3_END_CNT", rset.getString("EXP_LOSS_RATE_3_END_CNT"));
//				obj.put("EXP_LOSS_RATE_3_EXPRATE", rset.getString("EXP_LOSS_RATE_3_EXPRATE"));
//				obj.put("EXP_LOSS_RATE_3_VERSION", rset.getString("EXP_LOSS_RATE_3_VERSION"));
//				obj.put("EXP_LOSS_RATE_4_ALL_CNT", rset.getString("EXP_LOSS_RATE_4_ALL_CNT"));
//				obj.put("EXP_LOSS_RATE_4_END_CNT", rset.getString("EXP_LOSS_RATE_4_END_CNT"));
//				obj.put("EXP_LOSS_RATE_4_EXPRATE", rset.getString("EXP_LOSS_RATE_4_EXPRATE"));
//				obj.put("EXP_LOSS_RATE_4_VERSION", rset.getString("EXP_LOSS_RATE_4_VERSION"));
//				obj.put("EXP_LOSS_RATE_5_ALL_CNT", rset.getString("EXP_LOSS_RATE_5_ALL_CNT"));
//				obj.put("EXP_LOSS_RATE_5_END_CNT", rset.getString("EXP_LOSS_RATE_5_END_CNT"));
//				obj.put("EXP_LOSS_RATE_5_EXPRATE", rset.getString("EXP_LOSS_RATE_5_EXPRATE"));
//				obj.put("EXP_LOSS_RATE_5_VERSION", rset.getString("EXP_LOSS_RATE_5_VERSION"));
//				obj.put("WEI_EFF_RATE_LOSS_PARM_VAL", rset.getString("WEI_EFF_RATE_LOSS_PARM_VAL"));
//				obj.put("WEI_EFF_RATE_LOSS_SRC_CNT", rset.getString("WEI_EFF_RATE_LOSS_SRC_CNT"));
//				obj.put("WEI_EFF_RATE_NORMAL_PARM_VAL", rset.getString("WEI_EFF_RATE_NORMAL_PARM_VAL"));
//				obj.put("WEI_EFF_RATE_NORMAL_SRC_CNT", rset.getString("WEI_EFF_RATE_NORMAL_SRC_CNT"));
//				obj.put("LOSS_PERIOD_PARM_VAL", rset.getString("LOSS_PERIOD_PARM_VAL"));
//				obj.put("LOSS_PERIOD_SRC_CNT", rset.getString("LOSS_PERIOD_SRC_CNT"));
//				obj.put("LOSS_AGG_GL_MTH_ACC_BAL_AMT", rset.getString("LOSS_AGG_GL_MTH_ACC_BAL_AMT"));
//				obj.put("LOSS_AGG_GL_LOSS_POSITION", rset.getString("LOSS_AGG_GL_LOSS_POSITION"));
//				obj.put("LOSS_AGG_GL_CASH_FLOW_NPV", rset.getString("LOSS_AGG_GL_CASH_FLOW_NPV"));
//				obj.put("LOSS_AGG_GL_LOSS_AMT", rset.getString("LOSS_AGG_GL_LOSS_AMT"));
//				obj.put("LOSS_AGG_GL_CNT_RECORD", rset.getString("LOSS_AGG_GL_CNT_RECORD"));
//				obj.put("LOSS_AGG_NGL_MTH_ACC_BAL_AMT", rset.getString("LOSS_AGG_NGL_MTH_ACC_BAL_AMT"));
//				obj.put("LOSS_AGG_NGL_LOSS_POSITION", rset.getString("LOSS_AGG_NGL_LOSS_POSITION"));
//				obj.put("LOSS_AGG_NGL_CASH_FLOW_NPV", rset.getString("LOSS_AGG_NGL_CASH_FLOW_NPV"));
//				obj.put("LOSS_AGG_NGL_LOSS_AMT", rset.getString("LOSS_AGG_NGL_LOSS_AMT"));
//				obj.put("LOSS_AGG_NGL_CNT_RECORD", rset.getString("LOSS_AGG_NGL_CNT_RECORD"));
//				obj.put("LOSS_AGG_NORM_MTH_ACC_BAL_AMT", rset.getString("LOSS_AGG_NORM_MTH_ACC_BAL_AMT"));
//				obj.put("LOSS_AGG_NORM_LOSS_POSITION", rset.getString("LOSS_AGG_NORM_LOSS_POSITION"));
//				obj.put("LOSS_AGG_NORM_CASH_FLOW_NPV", rset.getString("LOSS_AGG_NORM_CASH_FLOW_NPV"));
//				obj.put("LOSS_AGG_NORM_LOSS_AMT", rset.getString("LOSS_AGG_NORM_LOSS_AMT"));
//				obj.put("LOSS_AGG_NORM_CNT_RECORD", rset.getString("LOSS_AGG_NORM_CNT_RECORD"));
//				obj.put("LOSS_AGG_ALL_MTH_ACC_BAL_AMT", rset.getString("LOSS_AGG_ALL_MTH_ACC_BAL_AMT"));
//				obj.put("LOSS_AGG_ALL_LOSS_POSITION", rset.getString("LOSS_AGG_ALL_LOSS_POSITION"));
//				obj.put("LOSS_AGG_ALL_CASH_FLOW_NPV", rset.getString("LOSS_AGG_ALL_CASH_FLOW_NPV"));
//				obj.put("LOSS_AGG_ALL_LOSS_AMT", rset.getString("LOSS_AGG_ALL_LOSS_AMT"));
//				obj.put("LOSS_AGG_ALL_CNT_RECORD", rset.getString("LOSS_AGG_ALL_CNT_RECORD"));

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
		System.out.println(JSONObjectList.toString());
		return JSONObjectList;
	}
}
