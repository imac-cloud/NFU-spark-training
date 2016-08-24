package com.imac;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class MySQL2 implements Serializable {
	//MySQL 基本設定(包含驅動、url、table、帳號、密碼)
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost/test";
	private static final String MYSQL_DBtable = "class1";
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PWD = "root";

	public static void main(String[] args) {
		SparkConf sc = new SparkConf().setAppName("MySQL");
	    JavaSparkContext ctx = new JavaSparkContext(sc);
	    SQLContext sqlContext = new SQLContext(ctx);
	    
	    //MySQL 資料串接並轉換成 DataFrame
	    Map<String, String> options = new HashMap<String, String>();
	    options.put("url", MYSQL_CONNECTION_URL);
	    options.put("driver", MYSQL_DRIVER);
	    options.put("dbtable", MYSQL_DBtable);
	    options.put("user", MYSQL_USERNAME);
	    options.put("password", MYSQL_PWD);
	    
	    DataFrame DF = sqlContext.read().format("jdbc").options(options).load();
	    
	    //選擇列出前兩筆資料的 Name 和 Age 欄位
		DF.select("Name", "Age").show(2);
		
		//用關聯式語法挑出年紀大於 22 以及身高大於 160 的資料
		DF.registerTempTable("class");
		DataFrame testDF = sqlContext.sql("SELECT * FROM class WHERE Age > 20 AND Height > 160");
		
		testDF.show();
	}

}
