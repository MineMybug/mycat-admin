/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月19日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.classTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import com.mysql.jdbc.Driver;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年12月19日
 */
public class ClassLoadTest {

	public static void main(String[] args) throws Exception {
		// ClassLoader loader = Thread.currentThread().getContextClassLoader();
		// System.out.println(loader);
		// System.out.println(loader.getParent());
		// System.out.println(loader.getParent().getParent());
		//
		// Class te = Class.forName("com.gihubMyMinebug.test.classTest.Test");
		// System.out.println(te.getName());
		String url = "jdbc:mysql://10.10.203.132:3306/test";
		String username = "sync_ctmg";
		String password = "sync_ctmg";
//		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new Driver());
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "SELECT * FROM test";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery();
		resultSet.next();
		String address = resultSet.getString("code");
		System.out.println(address);
	}

}
