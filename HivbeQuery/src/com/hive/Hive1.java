package com.hive;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
public class Hive1 {
		private static String driverName = "org.apache.hive.jdbc.HiveDriver";
		/**
		 * @param args
		 * @throws SQLException
		 */

		public static void main(String[] args) throws SQLException {
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}

			Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default", "acadgild", "");
			Statement stmt = con.createStatement();
			String tableName = "olympics_data3";
			stmt.execute("drop table if exists " + tableName);			
			String sql = "SELECT country,sum(T_medals) FROM olympics_data3 where sport=='Swimming' group by country";
			System.out.println("Running: " + sql);
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println(res.getString(1) + "\t" + res.getInt(2));
			}
			
		}
	
}
