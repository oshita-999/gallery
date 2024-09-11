package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
  
  public static ImageDao createImageDao() {	
	return new ImageDaoImpl(getDataSource());
  }

  //【１２】
  private static DataSource getDataSource() {
	DataSource ds = null;
	try {
	  InitialContext ctx = new InitialContext();
	  ds = (DataSource) ctx.lookup("java:comp/env/jdbc/shop_db");
	} catch (Exception e) {
	  e.printStackTrace();
	}

	return ds;

  }

}
